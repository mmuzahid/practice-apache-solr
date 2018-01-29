# practice-apache-solr

#### Solr Setup on Windows: ####

1. Install Java **1.8.0** or higher and set environment variable **SOLR_JAVA_HOME** by the location of java 1.8.0.
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

#### Create Solr Core using comamnd ####
To create a Solr **core** which will contain newly created **document** run following command:

    ```
    solr create -c my-practice-core
    ```

#### Solr with Jersey (REST Client): ####   
Add **Jersey** dependences in **pom.xml**
   	
	```xml
	 <dependency>
		<groupId>com.sun.jersey</groupId>
		<artifactId>jersey-core</artifactId>
		<version>1.9.1</version>
	</dependency>
	<dependency>
		<groupId>com.sun.jersey</groupId>
		<artifactId>jersey-client</artifactId>
		<version>1.9.1</version>
	</dependency>
	<dependency>
		<groupId>com.sun.jersey</groupId>
		<artifactId>jersey-server</artifactId>
		<version>1.9.1</version>
	</dependency>
	<dependency>
		<groupId>com.sun.jersey</groupId>
		<artifactId>jersey-json</artifactId>
		<version>1.9.1</version>
	</dependency>   
	```

#### Solr with SolrJ (a Java Library): ####
Add **SolrJ** dependency in **pom.xml**
	
	```xml
	<dependency>
	  <groupId>org.apache.solr</groupId>
	  <artifactId>solr-solrj</artifactId>
	  <version>7.1.0</version>
	</dependency>	
	```

> Referrence: 
    1. https://lucene.apache.org/solr/guide/6_6/using-solrj.html#UsingSolrJ-BuildingandRunningSolrJApplications
    2. http://www.mkyong.com/solr/apache-solr-hello-world-example/
