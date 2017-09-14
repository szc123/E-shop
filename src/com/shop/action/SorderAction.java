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
		//1.������Ʒid��ȡ��Ӧ������
		Product product=productService.get(model.getProduct().getId());
		//2.�ж�session���Ƿ��й��ﳵ�����û���򴴽�
		if(session.get("forder")==null){
			//�������ﳵ
			session.put("forder", new Forder(new HashSet<Sorder>()));
		}
		//3.����Ʒ��Ϣת��Ϊ�����������ӵ����ﳵ��
		Forder forder=(Forder) session.get("forder");
		forder=sorderService.addSorder(forder, product);
		//4.���㹺���ܼ۸�
		forder.setTotal(forderService.cluTotal(forder));
		//5.���µĹ��ﳵ�洢��session��
		session.put("forder", forder);
		return "showCart";
	}
	public String querySale(){
		List<Object> jsonList=sorderService.querySale(model.getNumber());
		//����ѯ������list����ֵջ��
		ActionContext.getContext().getValueStack().push(jsonList);
		return "jsonList";
	}
}
