package com.cav.spring.service.bank.repository;

import static org.junit.Assert.assertTrue;


import java.util.List;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.cav.spring.service.bank.AbstractTest;
import com.cav.spring.service.bank.model.accounts.Accounts;
import com.cav.spring.service.bank.model.banks.BankPOJO;
import com.cav.spring.service.bank.model.banks.Banks;
import com.cav.spring.service.bank.model.funds.FundId;
import com.cav.spring.service.bank.model.funds.Funds;



@RunWith(SpringRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations="classpath:springTest.xml") 
public abstract class AbstractRepositoryTest extends AbstractTest {
	
	
	
	@Autowired
	protected BankRepository bankRepository;
	
	@Autowired
	protected AccountRepository accountRepository;
	
	@Autowired
	protected FundRepository fundRepository;
	
	public void setUp(){
		List<BankPOJO> bankList = createBankList();
		bankRepository.createBanks(bankList);
	}
	
	public void cleanUp(){
		bankRepository.removeBanks(createIds(DEFAULT_BANK_ID));
		Banks banks = bankRepository.findBanks(createIds(DEFAULT_BANK_ID));
		assertTrue(banks.getBankList().isEmpty());	
		
		accountRepository.removeAccounts(createIds(DEFAULT_ACCOUNT_ID));
		Accounts accounts = accountRepository.findAccounts(createIds(DEFAULT_ACCOUNT_ID));
		assertTrue(accounts.getAccountsList().isEmpty());
		
		accountRepository.removeAccounts(createIds(NEW_ACCOUNT_ID));
		accounts = accountRepository.findAccounts(createIds(NEW_ACCOUNT_ID));
		assertTrue(accounts.getAccountsList().isEmpty());
		
		fundRepository.removeFunds(createIds(DEFAULT_FUND_ID));
		Funds funds = fundRepository.findFunds(createIds(DEFAULT_FUND_ID));
		assertTrue(funds.getFundList().isEmpty());
		
		fundRepository.removeFunds(createIds(DEFAULT_FUND_ID));
		funds = fundRepository.findFunds(createIds(DEFAULT_FUND_ID));
		assertTrue(funds.getFundList().isEmpty());
	}
	
	

}
