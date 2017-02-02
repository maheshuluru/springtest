package jp.uluru.payment.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import jp.uluru.payment.model.Client;

@Transactional
public interface ClientRepository extends CrudRepository<Client, Integer>{

	@Query("SELECT c FROM Client c WHERE c.apiTokenTest=:token")
	public Client findByApiTokenTest(@Param("token") String token);
	
	@Query("SELECT c FROM Client c WHERE c.apiTokenLive=:token")
	public Client findByApiTokenLive(@Param("token") String token);
}
