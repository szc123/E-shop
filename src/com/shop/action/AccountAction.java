package com.shop.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.shop.model.Account;
@Controller("accountAction")
@Scope("prototype")
public class AccountAction extends BaseAction<Account> {
	private static final long serialVersionUID = 1L;
	//�������е��˻���Ϣ
	public String query(){
		jsonList=accountService.query();
		return "jsonList";
	}
	
}
