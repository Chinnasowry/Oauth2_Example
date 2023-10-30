package com.example.Sample;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableOAuth2Sso
public class SampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SampleApplication.class, args);

		// Keycloak server details
		String serverUrl = "http://localhost:9000/realms/eazybankdev/protocol/openid-connect/token";
		String clientId = "eazybankapi";
		String clientSecret = "OlxWbU84txo6bEuTHxxNKxS9ooxpv4Ie";

		// Request body
		String requestBody = "grant_type=client_credentials&client_id=" + clientId + "&client_secret=" + clientSecret;

		// Create the HTTP client and post the request
		HttpClient httpClient = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost(serverUrl);

		try {
			httpPost.setEntity(new StringEntity(requestBody));
			httpPost.setHeader("Content-Type", "application/x-www-form-urlencoded");

			HttpResponse response = httpClient.execute(httpPost);
			HttpEntity entity = response.getEntity();

			if (entity != null) {
				// Read the response and extract the access token
				String responseString = EntityUtils.toString(entity);
				System.out.println("Response: " + responseString);

				// Extract the access token from the response JSON
				String accessToken = responseString.split("\"access_token\":\"")[1].split("\"")[0];
				System.out.println("Access Token: " + accessToken);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


}
