package com.shop.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.shop.model.Forder;
import com.shop.model.Status;
import com.shop.model.User;
@Controller("forderAction")
@Scope("prototype")
public class ForderAction extends BaseAction<Forder> {
	
	private static final long serialVersionUID = 1L;
	public Forder getModel() {
		model=(Forder) session.get("forder");
		return model;
	}
	//订单与购物项级联入库
	public String save(){
		model.setUser((User) session.get("user"));
		model.setStatus(new Status(1));
		forderService.save(model);
		
		//此时购物车已经入库，原来session中的购物车就要清空
		session.put("oldForder", session.get("forder"));//保存原来购物车信息，付款时需要
		session.put("forder", new Forder());//新建一个购物车，相当于清空购物车
		return "bank";
	}
	
}
