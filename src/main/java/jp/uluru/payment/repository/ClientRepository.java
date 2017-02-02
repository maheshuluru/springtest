package jp.uluru.payment.repository;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import jp.uluru.payment.model.Client;

@Transactional
public interface ClientRepository extends CrudRepository<Client, Integer>{

}
