package org.my.prac;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.ws.rs.core.MediaType;

import com.google.gson.JsonObject;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class SolrRestExmapleImp implements SolrRestExample {

	private String url;

	public SolrRestExmapleImp(String url) {
		this.url = url;
	}

	@Override
	public String findDocuments(String query) {
		Client client = Client.create();
		WebResource webResource;
		try {
			query = URLEncoder.encode(query, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		webResource = client.resource(url + "/select?q=" + query);
		System.out.println("findDocuments at "+ webResource.getURI());
		ClientResponse response = webResource.type(MediaType.APPLICATION_JSON)
				.get(ClientResponse.class);
		return response.getEntity(String.class).toString();
	}

	@Override
	public String updateDocuments(String documentArray) {
		return updateDocuments(documentArray, MediaType.APPLICATION_JSON);
	}

	@Override
	public String updateDocuments(String jsonDocs,String contentType) {
		Client client = Client.create();
		WebResource webResource;
		webResource = client.resource(url + "/update?commit=true");
		System.out.println("updateDocuments at "+ webResource.getURI());
		ClientResponse response = webResource.type(contentType).post(ClientResponse.class, jsonDocs);
		return response.getEntity(String.class).toString();
	}

	@Override
	public String updateJsonDocuments(String jsonDocs) {
		Client client = Client.create();
		WebResource webResource;
		webResource = client.resource(url + "/update/json/docs?commit=true");
		System.out.println("updateJsonDocuments at "+ webResource.getURI());
		ClientResponse response = webResource.type(MediaType.APPLICATION_JSON).post(ClientResponse.class, jsonDocs);
		return response.getEntity(String.class).toString();
	}
	
	@Override
	public String deleteDocuments(String solrQuery) {
		Client client = Client.create();
		WebResource webResource;
		webResource = client.resource(url + "/update?commit=true");
		JsonObject deleteJsonRequest = new JsonObject();
		JsonObject deleteProperty = new JsonObject();
		deleteProperty.addProperty("query", solrQuery);
		deleteJsonRequest.add("delete", deleteProperty);
		System.out.println("deleteDocuments at "+ webResource.getURI());
		ClientResponse response = webResource.type(MediaType.APPLICATION_JSON)
				.post(ClientResponse.class, deleteJsonRequest.toString());
		return response.getEntity(String.class).toString();

	}

}
