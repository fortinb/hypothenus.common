package com.isoceles.hypothenus.tests.security;

import java.util.UUID;

import org.springframework.http.HttpHeaders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


public class SecurityUtils {

	public static final String X_Authorization = "x-authorization";
	public static final String X_Credentials = "x-credentials";
	public static final String X_TrackingNumber = "x-tracking-number";

	public static HttpHeaders getHeaders(String role, String username) throws JsonProcessingException {
		
		HttpHeaders headers = new HttpHeaders();
		headers.add(X_Credentials, username);
		headers.add(X_TrackingNumber, UUID.randomUUID().toString());
		
		AuthorizationHeader authorization = new AuthorizationHeader();
		authorization.addRole(role);
		ObjectMapper mapper = new ObjectMapper();
		headers.add(X_Authorization, mapper.writeValueAsString(authorization));
		
		return headers;
	}
	
}
