package com.cav.spring.service.bank.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Service;

import com.cav.spring.service.bank.entity.Fund;
import com.cav.spring.service.bank.model.funds.FundId;
import com.cav.spring.service.bank.model.funds.FundPOJO;
import com.cav.spring.service.bank.model.funds.Funds;
import com.cav.spring.service.bank.repository.FundRepository;
import com.cav.spring.service.bank.repository.MappEntitiesAbstract;


@Service
public class FundServiceImpl implements FundService {

    @Autowired
	private FundRepository repository;
	
	public void updateFunds(Funds funds) {
		repository.updateFunds(funds.getFundList());	
	}

	public Funds listFunds(List<FundId> fundIds) {
		Funds funds = repository.findFunds(mapIds(fundIds));
		return funds;
	}

	public void removeFunds(List<FundId> fundIds) {
		repository.removeFunds(mapIds(fundIds));
	}
	
	private List <Long> mapIds(List<FundId> fundIds){
		Iterator<FundId> iter = fundIds.iterator();
		List <Long> ids = new ArrayList<Long>();
		while(iter.hasNext()){
			ids.add(iter.next().getId());
		}
		return ids;
	}
	
}
