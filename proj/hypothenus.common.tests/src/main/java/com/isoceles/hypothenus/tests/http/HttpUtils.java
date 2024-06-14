package com.isoceles.hypothenus.tests.http;

import java.net.MalformedURLException;
import java.net.URI;
import java.util.UUID;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.MultiValueMap;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.isoceles.hypothenus.tests.security.SecurityUtils;

public class HttpUtils<T> {
	public static final String X_TrackingNumber = "x-tracking-number";
	
	public static final URI createURL(URI uri, int port, MultiValueMap<String, String> queryStringParameters) throws MalformedURLException {
		URI target = UriComponentsBuilder.newInstance()
			.scheme("http")
			.port(port)
			.host("localhost")
			.path(uri.getPath())
			.queryParams(queryStringParameters)
			.build()
			.toUri();
		
		return target;
	}
	
	public static final <T> HttpEntity<T> createHttpEntity(String role, String admin, T body) throws JsonProcessingException {
		HttpHeaders httpHeaders = SecurityUtils.getHeaders(role, admin);
		
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		
		httpHeaders.add(X_TrackingNumber, UUID.randomUUID().toString());
		
		HttpEntity<T> httpEntity = new HttpEntity<T>(body, httpHeaders);
		
		return httpEntity;
	}
}
