package com.shop.action;

import java.util.HashSet;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.shop.model.Forder;
import com.shop.model.Product;
import com.shop.model.Sorder;
@Controller("sorderAction")
@Scope("prototype")
public class SorderAction extends BaseAction<Sorder> {
	
	private static final long serialVersionUID = 1L;

	public String addSorder(){
		//1.根据商品id获取相应的数据
		Product product=productService.get(model.getProduct().getId());
		//2.判断session中是否有购物车，如果没有则创建
		if(session.get("forder")==null){
			//创建购物车
			session.put("forder", new Forder(new HashSet<Sorder>()));
		}
		//3.把商品信息转化为购物项，并且添加到购物车中
		Forder forder=(Forder) session.get("forder");
		forder=sorderService.addSorder(forder, product);
		//4.计算购物总价格
		forder.setTotal(forderService.cluTotal(forder));
		//5.把新的购物车存储到session中
		session.put("forder", forder);
		return "showCart";
	}
	public String querySale(){
		List<Object> jsonList=sorderService.querySale(model.getNumber());
		//将查询出来的list放入值栈中
		ActionContext.getContext().getValueStack().push(jsonList);
		return "jsonList";
	}
}
