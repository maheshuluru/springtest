package jp.uluru.payment.config;

import java.io.IOException;
import java.util.List;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

import org.springframework.beans.factory.annotation.Autowired;

import jp.uluru.payment.model.Client;
import jp.uluru.payment.service.ClientService;

@Provider
@PreMatching
public class MySecurityFilter implements ContainerRequestFilter {

	private static final String AUTH_TOKEN = "Authorization";
	private static final String AUTH_TOKEN_PREFIX = "Bearer ";

	@Autowired
	private ClientService clientService;

	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		if (requestContext.getUriInfo().getPath().contains("banks")) {
			List<String> headers = requestContext.getHeaders().get(AUTH_TOKEN);
			if (headers != null && headers.size() > 0) {
				String token = headers.get(0);
				token = token.replaceFirst(AUTH_TOKEN_PREFIX, "");
				Client client;
				if (token.startsWith("live_")) {
					client = clientService.getClientByApiTokenLive(token);
				} else {
					client = clientService.getClientByApiTokenTest(token);
				}
				if (client != null) {
					System.out.println("Provided token is : " + token);
					System.out.println("Client : " + client.toString());
					String scheme = requestContext.getUriInfo().getRequestUri().getScheme();
					requestContext.setSecurityContext(new MyApplicationSecurityContext(client, scheme));
					return;
				}
			}
			Response unauthorised = Response.status(Response.Status.UNAUTHORIZED).entity("Can not access this resource")
					.build();
			requestContext.abortWith(unauthorised);
		}

	}

}
