package com.isoceles.hypothenus.tests.security;

import org.springframework.http.HttpHeaders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class SecurityUtils {

	public static final String X_Authorization = "x-authorization";
	public static final String X_Credentials = "x-credentials";
	
	private static ObjectMapper objectMapper = new ObjectMapper();
	
	public static HttpHeaders getHeaders(String role, String username) throws JsonProcessingException {

		HttpHeaders headers = new HttpHeaders();
		headers.add(X_Credentials, username);

		AuthorizationHeader authorization = new AuthorizationHeader();
		authorization.addRole(role);
		
		headers.add(X_Authorization, objectMapper.writeValueAsString(authorization));
 
		return headers;
	}

}
