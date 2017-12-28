package org.my.prac;

import java.io.IOException;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.client.solrj.response.UpdateResponse;
import org.apache.solr.common.SolrInputDocument;

public class PracticeSolr {

	public static void main(String[] args) throws SolrServerException, IOException {
		String urlString = "http://localhost:8983/solr/my-practice-core";
		SolrClient solr = new HttpSolrClient.Builder(urlString).build();
		System.out.println("Update Document response: " + updateSampleDocument(solr));
		System.out.println("Query Document response:" + querySampleDocument(solr));
	}

	private static QueryResponse querySampleDocument(SolrClient solr)
			throws SolrServerException, IOException {
		SolrQuery query = new SolrQuery();
		String searchKey = "id";
		String searchValue = "55555";
		query.set("q", searchKey + ":" + searchValue);
		QueryResponse response = solr.query(query);
		return response;
	}

	private static UpdateResponse updateSampleDocument(SolrClient solr)
			throws SolrServerException, IOException {
		SolrInputDocument document = new SolrInputDocument();
		document.addField("id", "55555");
		document.addField("name", "5 * Five");
		document.addField("price", "55.55");
		UpdateResponse updateResponse = solr.add(document);
		updateResponse = solr.commit();
		return updateResponse;
	}

}
