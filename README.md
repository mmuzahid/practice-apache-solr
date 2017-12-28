# practice-apache-solr

#### Solr Setup on Windows: ####

1. Setup Java8
2. Download **zip** file (e.g. solr-7.1.0.zip) from **Solr** site. Sample download link http://www-eu.apache.org/dist/lucene/solr/7.1.0
3. Extract downloaded **zip** file to any directory (e.g. solr directory D:\apache-soft\solr-7.1.0).
4. Using command prompt go to the **bin** folder of solr (e.g. D:\apache-soft\solr-7.1.0\bin).
5. Run following command to run **Solr** and show status:
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
	```	xml
	<dependency>
	  <groupId>org.apache.solr</groupId>
	  <artifactId>solr-solrj</artifactId>
	  <version>x.y.z</version>
	</dependency>	
	```

2. To create a Solr **core** which will contain newly created **document** run following command:
    ```
    solr create -c my-practice-core
    ```

> Referrence: 
 * https://lucene.apache.org/solr/guide/6_6/using-solrj.html#UsingSolrJ-BuildingandRunningSolrJApplications
 * http://www.mkyong.com/solr/apache-solr-hello-world-example/