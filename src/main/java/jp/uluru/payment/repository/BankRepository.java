package jp.uluru.payment.repository;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import jp.uluru.payment.model.Bank;

@Transactional
public interface BankRepository extends CrudRepository<Bank, Integer>{

}
