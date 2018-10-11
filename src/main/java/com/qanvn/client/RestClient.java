package com.qanvn.client;

import java.io.IOException;
import java.util.HashMap;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;

public class RestClient {

	// GET method without headers

	public void get(String url) throws ClientProtocolException, IOException {
		//create client connection
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet httpget = new HttpGet(url);
		//execute the url and get response
		CloseableHttpResponse closeablehttpResponse = httpClient.execute(httpget);
		//status code
		int statuscode = closeablehttpResponse.getStatusLine().getStatusCode();
		System.out.println(statuscode);
		Assert.assertEquals(statuscode, 200, "It is RIGHT status code");
		System.out.println();
		//response String
		String responseString = EntityUtils.toString(
				closeablehttpResponse.getEntity(), "UTF-8");
		JSONObject responseJson = new JSONObject();
		System.out.println("Response Json from API---> "+ responseJson);
		//headers
		Header[] headersArray = closeablehttpResponse.getAllHeaders();

		HashMap<String, String> allHeaders = new HashMap<String, String>();

		for (Header header : headersArray) {

			allHeaders.put(header.getName(), header.getValue());
		}
		System.out.println("All the API headers---> " + allHeaders);

	}

}
