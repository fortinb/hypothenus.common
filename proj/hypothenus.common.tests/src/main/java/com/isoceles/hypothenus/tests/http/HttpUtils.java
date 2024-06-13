package com.isoceles.hypothenus.tests.http;

import java.net.MalformedURLException;
import java.net.URI;

import org.springframework.util.MultiValueMap;
import org.springframework.web.util.UriComponentsBuilder;

public class HttpUtils {
	
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
}
