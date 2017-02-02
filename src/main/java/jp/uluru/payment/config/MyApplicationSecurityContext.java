package jp.uluru.payment.config;

import java.security.Principal;

import javax.ws.rs.core.SecurityContext;

import jp.uluru.payment.model.Client;

public class MyApplicationSecurityContext implements SecurityContext {

	private Client client;
	private String scheme;

	public MyApplicationSecurityContext(Client client, String scheme) {
		super();
		this.client = client;
		this.scheme = scheme;
	}

	@Override
	public String getAuthenticationScheme() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Principal getUserPrincipal() {
		return this.client;
	}

	@Override
	public boolean isSecure() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isUserInRole(String arg0) {
		// TODO Auto-generated method stub
		return false;
	}

}
