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
	//�����빺��������
	public String save(){
		model.setUser((User) session.get("user"));
		model.setStatus(new Status(1));
		forderService.save(model);
		
		//��ʱ���ﳵ�Ѿ���⣬ԭ��session�еĹ��ﳵ��Ҫ���
		session.put("oldForder", session.get("forder"));//����ԭ�����ﳵ��Ϣ������ʱ��Ҫ
		session.put("forder", new Forder());//�½�һ�����ﳵ���൱����չ��ﳵ
		return "bank";
	}
	
}
