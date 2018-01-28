package org.my.prac;

public interface SolrRestExample {

	public String findDocuments(String query);

	public String updateDocuments(String documentArray);

	public String updateDocuments(String documentArray, String contentType);

	public String updateJsonDocuments(String json);

	public String deleteDocuments(String solrQuery);

}
