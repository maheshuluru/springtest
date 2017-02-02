package jp.uluru.payment.config;

import java.io.IOException;
import java.util.List;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.ext.Provider;

@Provider
@PreMatching
public class MySecurityFilter implements ContainerRequestFilter {

	private static final String AUTH_TOKEN = "Authorization";

	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		System.out.println("Control comes here");
		List<String> headers = requestContext.getHeaders().get(AUTH_TOKEN);
		if (headers.size() > 0) {
			System.out.println(requestContext.getHeaders().get(AUTH_TOKEN));
		} else {
			System.out.println("There is no auth header provided");
		}
		return;
	}

}
