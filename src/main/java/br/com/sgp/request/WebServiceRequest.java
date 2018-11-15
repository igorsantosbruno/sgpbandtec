package br.com.sgp.request;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

public class WebServiceRequest {
	
public WebServiceRequest() {
		
	}
	
	public String request(String endpoint) {

		CloseableHttpClient client= HttpClientBuilder.create().build();
		HttpGet request = new HttpGet(endpoint);
		request.addHeader("content-type", "application/json");
		request.addHeader("Accept", "application/json");
		HttpResponse response = null;
		String json = "";

		try {

			response = client.execute(request);
		} catch (ClientProtocolException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}

		try {

			json = EntityUtils.toString(response.getEntity());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return json;
	}
	
	public void requestPost(String endpoint, StringEntity params) {

		CloseableHttpClient client = HttpClientBuilder.create().build();
		HttpPost request = new HttpPost(endpoint);
		request.addHeader("content-type", "application/json");
		request.addHeader("Accept", "application/json");
		request.setEntity(params);
		try {

			client.execute(request);
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

}
