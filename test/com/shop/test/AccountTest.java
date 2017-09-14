package com.shop.test;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.shop.model.Account;
import com.shop.service.AccountService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:beans.xml")
public class AccountTest {
	@Resource
	private AccountService accoutService;
	@Test
	public void testAccountQuery(){
		
		List<Account> list=accoutService.query();
		for (Account account : list) {
			System.out.println(account.getName());
		}
	}
}
