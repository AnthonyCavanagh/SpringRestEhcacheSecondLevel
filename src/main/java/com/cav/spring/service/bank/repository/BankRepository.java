package com.cav.spring.service.bank.repository;

import java.util.List;

import com.cav.spring.service.bank.model.banks.BankId;
import com.cav.spring.service.bank.model.banks.BankPOJO;
import com.cav.spring.service.bank.model.banks.Banks;

public interface BankRepository {
	public Banks findBanks(List<Long>bankIdS);
	public void createBanks(List<BankPOJO> banks);
	public void updateBanks(List<BankPOJO> banks);
	public void removeBanks(List<Long> bankIds);
	public void removeAccounts(List <BankId> bankIds);
}
