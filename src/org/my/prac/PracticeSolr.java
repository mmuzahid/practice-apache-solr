package org.my.prac;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.core.MediaType;

import org.apache.solr.client.solrj.SolrServerException;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class PracticeSolr {

	public static void main(String[] args) throws SolrServerException, IOException {
		String urlString = "http://localhost:8983/solr/my-practice-core";
		SolrJExample solrj = SolrJExample.getSolrJExample(urlString);
		Map<String, Object> updateData = new HashMap<String, Object>();
		updateData.put("id", "55555");
		updateData.put("name", "5 * Five");
		updateData.put("price", "55.55");
		System.out.println("Update Document response: " + solrj.updateDocument(updateData));
		System.out.println("Query Document response:" + solrj.queryDocument("id", "55555"));
		System.out.println("Delete Document response:" + solrj.deleteDocument("id", "55555"));
		
        JsonObject jsonDataProperty = new JsonObject();
        jsonDataProperty.addProperty("id", "val1");
		JsonObject jsonDoc = new JsonObject();
        JsonObject jsonProperty = new JsonObject();
        jsonDoc.add("outer_field", jsonProperty);
        jsonDoc.addProperty("timestamp_field", new Date().getTime());
        jsonDoc.addProperty("json_field", jsonDataProperty.toString());
        jsonDoc.addProperty("tag", "testdata");
        JsonArray jsonArray = new JsonArray();
        jsonArray.add(jsonDoc);
        jsonArray.add(jsonDoc);
		System.out.println(jsonArray);
		
		SolrRestExample solrRest = new SolrRestExmapleImp(urlString);
		System.out.println(solrRest.findDocuments("tag:testdata OR id:123"));
		System.out.println(solrRest.updateDocuments(jsonArray.toString()));
		System.out.println(solrRest.updateDocuments(jsonArray.toString(), MediaType.APPLICATION_JSON));
		System.out.println(solrRest.updateJsonDocuments(jsonDoc.toString()));
		System.out.println(solrRest.updateJsonDocuments(jsonArray.toString()));
		System.out.println(solrRest.deleteDocuments("tag:testdata OR id:123"));

	}

}
