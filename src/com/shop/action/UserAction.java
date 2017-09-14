package com.shop.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.shop.model.User;
@Controller("userAction")
@Scope("prototype")
public class UserAction extends BaseAction<User> {
	//�жϵ�½
	public String login(){
		model=userService.login(model);
		if(model==null){
			session.put("error", "��½ʧ�ܣ������û���������");
			return "login";
		}else{
			//��½�ɹ�
			session.put("user", model);
			//����Ҫ��ת��ҳ���Ƿ����
			if(session.get("goUrl")==null){
				return "index";//��ת��ҳ
			}else{
				return "goUrl";
			}				
		}
	}
}
