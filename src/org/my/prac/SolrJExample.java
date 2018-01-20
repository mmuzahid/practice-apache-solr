package org.my.prac;

import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.client.solrj.response.UpdateResponse;
import org.apache.solr.common.SolrInputDocument;

public class SolrJExample {

	private SolrClient solr;

	public static SolrJExample getSolrJExample(String url) {
		return new SolrJExample(url);
	}

	private SolrJExample(String url) {
		solr = new HttpSolrClient.Builder(url).build();
	}

	public QueryResponse queryDocument(String searchKey, String searchValue) throws SolrServerException, IOException {
		SolrQuery query = new SolrQuery();
		query.set("q", searchKey + ":" + searchValue);
		QueryResponse response = solr.query(query);
		return response;
	}

	public UpdateResponse updateDocument(Map<String, Object> updateData) throws SolrServerException, IOException {
		SolrInputDocument document = new SolrInputDocument();
		for (Entry<String, Object> entry : updateData.entrySet()) {
			document.addField(entry.getKey(), entry.getValue());
		}
		UpdateResponse updateResponse = solr.add(document);
		updateResponse = solr.commit();
		return updateResponse;
	}

	public UpdateResponse deleteDocument(String searchKey, String searchValue) throws SolrServerException, IOException {
		String query = searchKey + ":" + searchValue;
		UpdateResponse updateResponse = solr.deleteByQuery(query);
		updateResponse = solr.commit();
		return updateResponse;
	}
}
