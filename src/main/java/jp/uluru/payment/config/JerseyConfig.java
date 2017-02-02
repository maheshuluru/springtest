package jp.uluru.payment.config;

import javax.annotation.PostConstruct;
import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import jp.uluru.payment.resource.BankResource;
import jp.uluru.payment.resource.ClientResource;

@Component
@ApplicationPath("/api/v1")
public class JerseyConfig extends ResourceConfig{

	@PostConstruct
	private void init() {
		registerClasses(ClientResource.class);
		registerClasses(BankResource.class);
	}
}
