package jp.uluru.payment.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.uluru.payment.model.Bank;
import jp.uluru.payment.repository.BankRepository;

@Service
public class BankService {

	@Autowired
	private BankRepository bankRepository;

	public List<Bank> getAllbanks() {
		List<Bank> banks = new ArrayList<Bank>();
		bankRepository.findAll().forEach(banks::add);
		return banks;
	}

	public Bank getAbank(int id) {
		return bankRepository.findOne(id);
	}

	public Bank create(Bank bank) {
		return bankRepository.save(bank);
	}

	public Bank update(int id, Bank argBank) {
		Bank bank = bankRepository.findOne(id);
		argBank.setId(id);
		if (bank == null) {
			return null;
		} else {
			return bankRepository.save(argBank);
		}

	}

	public void delete(int id) {
		Bank bank = bankRepository.findOne(id);
		bankRepository.delete(bank);
	}

}
