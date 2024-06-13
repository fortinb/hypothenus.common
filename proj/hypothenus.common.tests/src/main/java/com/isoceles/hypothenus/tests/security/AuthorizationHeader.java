package com.isoceles.hypothenus.tests.security;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthorizationHeader {

	private List<String> roles = new ArrayList<String>();
	
	public void addRole(String role) {
		roles.add(role);
	}
}
