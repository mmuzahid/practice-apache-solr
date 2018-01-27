package org.my.prac;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.solr.client.solrj.SolrServerException;

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
		
		SolrRestExample solrRest = new SolrRestExmapleImp("http://localhost:8983/solr/my-practice-core");
		System.out.println(solrRest.findDocuments("ts:1517081065042 OR id:11111"));
		System.out.println(solrRest.updateDocuments(updateData.toString()));
		System.out.println(solrRest.deleteDocuments("id:3a6d88e9-f1b7-44d8-9c69-e0431717fc03 OR id:11111"));
	}

}
