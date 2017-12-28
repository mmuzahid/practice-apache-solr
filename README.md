# practice-apache-solr

#### Solr Setup on Windows: ####

1. Confirm Java version as **1.8.0** or higher.
2. Download **zip** file (e.g. solr-7.1.0.zip) from **Solr** site. Sample download link http://www-eu.apache.org/dist/lucene/solr/7.1.0
3. Extract downloaded **zip** file to any directory (e.g. solr directory D:\apache-soft\solr-7.1.0).
4. Set extracted Solr location as **SOLR_HOME** environment variable (e.g. D:\apache-soft\solr-7.1.0)
5. Add **%SOLR_HOME%\bin** to environment variable **Path** to execute solr commands.
6. Copy **solr.xml** from %SOLR_HOME%\server\solr\solr.xml and paste it in %SOLR_HOME%
7. Run following command to run **Solr** and show status:
    To start solr instance
    ```
    solr start
    ``` 
    To check status of solr instance
    ```
    solr status
    ```
    To stop solr instance
    ```
    solr stop
    ``` 	

> Installation Referrence: https://lucene.apache.org/solr/guide/6_6/running-solr.html 
#### Solr with Java: ####
1. Add **SolrJ** dependency in pom.xml
	```xml
	<dependency>
	  <groupId>org.apache.solr</groupId>
	  <artifactId>solr-solrj</artifactId>
	  <version>7.1.0</version>
	</dependency>	
	```

2. To create a Solr **core** which will contain newly created **document** run following command:
    ```
    solr create -c my-practice-core
    ```

> Referrence: 
    1. https://lucene.apache.org/solr/guide/6_6/using-solrj.html#UsingSolrJ-BuildingandRunningSolrJApplications
    2. http://www.mkyong.com/solr/apache-solr-hello-world-example/