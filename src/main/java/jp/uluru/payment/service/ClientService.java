package jp.uluru.payment.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.uluru.payment.model.Client;
import jp.uluru.payment.repository.ClientRepository;

@Service
public class ClientService {

	@Autowired
	private ClientRepository clientRepository;

	public List<Client> getAllClients() {
		List<Client> clients = new ArrayList<Client>();
		clientRepository.findAll().forEach(clients::add);
		System.out.println(clients);
		return clients;
	}

	public Client getAClient(int id) {
		return clientRepository.findOne(id);
	}

	public Client create(Client client) {
		return clientRepository.save(client);
	}

	public Client update(int id, Client argClient) {
		Client client = clientRepository.findOne(id);
		argClient.setId(id);
		if (client == null) {
			return null;
		} else {
			return clientRepository.save(argClient);
		}

	}

	public void delete(int id) {
		Client client = clientRepository.findOne(id);
		clientRepository.delete(client);
	}

	public Client getClientByApiTokenTest(String token) {
		return clientRepository.findByApiTokenTest(token);
	}
	public Client getClientByApiTokenLive(String token) {
		return clientRepository.findByApiTokenLive(token);
	}
}
