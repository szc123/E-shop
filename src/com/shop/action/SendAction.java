package com.shop.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
@Controller("sendAction")
@Scope("prototype")
public class SendAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	@Override
	public String execute() throws Exception {
		return "send";
	}
}
