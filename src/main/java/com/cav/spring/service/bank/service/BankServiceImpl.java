package com.cav.spring.service.bank.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cav.spring.service.bank.model.banks.BankId;
import com.cav.spring.service.bank.model.banks.Banks;
import com.cav.spring.service.bank.repository.BankRepository;

@Service
public class BankServiceImpl implements BankService{
	
	@Autowired
	private BankRepository repository;
	
	@Override
	public void createBanks(Banks banks) {
		repository.createBanks(banks.getBankList());
	}

	@Override
	public void updateBanks(Banks banks) {
		repository.updateBanks(banks.getBankList());	
	}

	@Override
	public Banks listBanks(List<BankId> bankIds) {
		Banks banks = repository.findBanks(mapIds(bankIds));
		return banks;
	}

	@Override
	public void removeBanks(List<BankId> bankIds) {
		// TODO Auto-generated method stub
	}
	
	private List <Long> mapIds(List<BankId> bankIds){
		Iterator<BankId> iter = bankIds.iterator();
		List <Long> ids = new ArrayList<Long>();
		while(iter.hasNext()){
			ids.add(iter.next().getId());
		}
		return ids;
	}
}
