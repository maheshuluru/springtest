package jp.uluru.payment.resource;

import java.util.List;

import javax.servlet.annotation.WebFilter;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;

import jp.uluru.payment.model.Bank;
import jp.uluru.payment.service.BankService;


@Path("/banks")
@Consumes(value = { MediaType.APPLICATION_JSON, MediaType.TEXT_XML })
@Produces(value = { MediaType.APPLICATION_JSON, MediaType.TEXT_XML })
public class BankResource {

	@Autowired
	BankService bankService;

	@GET
	public List<Bank> getAllbanks() {
		List<Bank> banks = bankService.getAllbanks();
		return banks;
	}

	@POST
	public Bank createAbank(@RequestParam(name = "bank") Bank bank) {
		return bankService.create(bank);
	}

	@GET
	@Path("/{id}")
	public Bank getAbank(@PathParam(value = "id") int id) {
		return bankService.getAbank(id);
	}

	@PUT
	@Path("/{id}")
	public Bank getAbank(@PathParam(value = "id") int id, @RequestParam(name = "bank") Bank bank) {
		return bankService.update(id, bank);
	}
	
	@DELETE
	@Path("/{id}")
	public void deleteAbank(@PathParam(value = "id") int id) {
		bankService.delete(id);
	}

	@GET
    @Produces(value=MediaType.TEXT_PLAIN)
    @Path("/hello")
    public String sayHello(@Context SecurityContext sc) {
		System.out.println("BankResource.sayHello() : "+sc.toString());
            if (sc.isUserInRole("admin"))  return "Hello World!";
            throw new SecurityException("User is unauthorized.");
    }
}
