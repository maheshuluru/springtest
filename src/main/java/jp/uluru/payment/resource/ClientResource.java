package jp.uluru.payment.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;

import jp.uluru.payment.model.Client;
import jp.uluru.payment.service.ClientService;

@Path("/clients")
@Consumes(value = { MediaType.APPLICATION_JSON, MediaType.TEXT_XML })
@Produces(value = { MediaType.APPLICATION_JSON, MediaType.TEXT_XML })
public class ClientResource {

	@Autowired
	ClientService clientService;

	@GET
	public List<Client> getAllClients() {
		List<Client> clients = clientService.getAllClients();
		return clients;
	}

	@POST
	public Client createAClient(@RequestParam(name = "client") Client client) {
		return clientService.create(client);
	}

	@GET
	@Path("/{id}")
	public Client getAClient(@PathParam(value = "id") int id) {
		return clientService.getAClient(id);
	}

	@PUT
	@Path("/{id}")
	public Client getAClient(@PathParam(value = "id") int id, @RequestParam(name = "client") Client client) {
		return clientService.update(id, client);
	}
	
	@DELETE
	@Path("/{id}")
	public void deleteAClient(@PathParam(value = "id") int id) {
		clientService.delete(id);
	}

}
