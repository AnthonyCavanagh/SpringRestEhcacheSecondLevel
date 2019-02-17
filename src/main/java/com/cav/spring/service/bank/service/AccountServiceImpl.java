package com.cav.spring.service.bank.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cav.spring.service.bank.entity.Account;
import com.cav.spring.service.bank.entity.Fund;
import com.cav.spring.service.bank.model.accounts.AccountId;
import com.cav.spring.service.bank.model.accounts.Accounts;
import com.cav.spring.service.bank.model.funds.FundId;
import com.cav.spring.service.bank.repository.AccountRepository;
import com.cav.spring.service.bank.repository.FundRepository;
import com.cav.spring.service.bank.repository.MappEntitiesAbstract;

@Service
public class AccountServiceImpl implements AccountService{

	
	@Autowired
	private AccountRepository repository;
	
	
	@Override
	public void updateAccounts(Accounts accounts) {
		repository.updateAccounts(accounts.getAccountsList());
		
	}

	@Override
	public Accounts listAccounts(List<AccountId> accountIds) {
		Accounts accounts = repository.findAccounts(mapIds(accountIds));
		return accounts;
	}

	@Override
	public void removeAccounts(List<AccountId> accountIds) {
		repository.removeAccounts(mapIds(accountIds));
	}
	
	private List <Long> mapIds(List<AccountId> accountIds){
		Iterator<AccountId> iter = accountIds.iterator();
		List <Long> ids = new ArrayList<Long>();
		while(iter.hasNext()){
			ids.add(iter.next().getId());
		}
		return ids;
	}

}
