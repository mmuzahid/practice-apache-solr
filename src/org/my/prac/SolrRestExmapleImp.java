package org.my.prac;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Date;

import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
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
		try {
			Client client = Client.create();
			WebResource webResource;
			query = URLEncoder.encode(query, "UTF-8");
			webResource = client.resource(url + "/select?q=" + query);

			System.out.println(webResource.getURI());
			ClientResponse response = webResource.type(
					MediaType.APPLICATION_JSON).get(ClientResponse.class);
			Gson gson = new Gson();
			return response.getEntity(String.class).toString();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String updateDocuments(String query) {
		try {
			Client client = Client.create();
			WebResource webResource;
			webResource = client.resource(url + "/update/json/docs?commit=true");
            JsonObject dataJson = new JsonObject();
            JsonObject jsonProperty = new JsonObject();
            jsonProperty.addProperty("value", query);
            dataJson.add("metadata", jsonProperty);
            dataJson.addProperty("ts", new Date().getTime());

			System.out.println(dataJson);
			ClientResponse response = webResource.type(
					MediaType.APPLICATION_JSON).post(ClientResponse.class, dataJson.toString());
			return response.getEntity(String.class).toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String deleteDocuments(String query) {
		try {
			Client client = Client.create();
			WebResource webResource;
			webResource = client.resource(url + "/update?commit=true");
            JsonObject deleteJson = new JsonObject();
            JsonObject deleteQuery = new JsonObject();
            deleteQuery.addProperty("query", query);
            deleteJson.add("delete", deleteQuery);
			System.out.println(deleteJson);
			ClientResponse response = webResource.type(
					MediaType.APPLICATION_JSON).post(ClientResponse.class, deleteJson.toString());
			return response.getEntity(String.class).toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
