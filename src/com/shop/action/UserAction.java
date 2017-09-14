package com.shop.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.shop.model.User;
@Controller("userAction")
@Scope("prototype")
public class UserAction extends BaseAction<User> {
	//判断登陆
	public String login(){
		model=userService.login(model);
		if(model==null){
			session.put("error", "登陆失败，请检查用户名或密码");
			return "login";
		}else{
			//登陆成功
			session.put("user", model);
			//根据要跳转的页面是否存在
			if(session.get("goUrl")==null){
				return "index";//跳转首页
			}else{
				return "goUrl";
			}				
		}
	}
}
