package com.qanvn.tests;


import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import com.qanvn.TestBase1.TestBase1;
import com.qanvn.client.RestClient;


public class GetAPITest extends TestBase1{
	TestBase1 testBase1;
	String serviceURL;
	String apiUrl;
	String url;
	RestClient restClient;
	
	
		@BeforeMethod
		public void setup(){
		testBase1= new TestBase1();	
		serviceURL=prop.getProperty("URL");
		apiUrl=prop.getProperty("serviceURL");
		url=serviceURL+apiUrl;
		}
		@Test
		public void getAPITest() throws ClientProtocolException, IOException{
			 restClient=new RestClient();
			 restClient.get(url);
			
		}
		
	}



