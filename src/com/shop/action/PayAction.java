package com.shop.action;

import java.util.Map;

import org.apache.struts2.interceptor.ParameterAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.shop.model.BackData;
import com.shop.model.Forder;
import com.shop.model.SendData;
import com.shop.model.User;
import com.shop.utils.EmailUtil;
import com.shop.utils.MessageUtil;
@Controller("payAction")
@Scope("prototype")
public class PayAction extends BaseAction<Object> implements ParameterAware {
	
	
	//定义一个Map接受request请求参数
	private Map<String, String[]> parameters;
	@Override
	public void setParameters(Map<String, String[]> parameters) {
		this.parameters=parameters;
	}
	//判断是哪个请求 ----- ServletConfig拦截器在ModelDriven之前先执行，所以我们在注入model的时候，
    //request参数已经有了，这样我们就可以在getModel()方法中通过参数来判断是哪个请求了
	@Override
	public Object getModel() {
		//付款的时候有支付通道编码的参数(pd_FrpId)，返回的时候没有
	    //这样我们就可以通过该参数判断是支付还是返回了
		if(parameters.get("pd_FrpId")!=null){
			model=new SendData();
		}else{
			model=new BackData();
		}
		return model;
	}
	//向易宝发送数据
	public String goBank(){
		Forder forder=(Forder) session.get("forder");
		User user=(User) session.get("user");
		SendData sendData = (SendData)model;
		sendData.setP2_Order(forder.getId().toString());
		sendData.setP3_Amt(forder.getTotal().toString());
		sendData.setPa_MP(user.getEmail()+","+user.getPhone());
		//存到request域中
		payService.saveDataToRequest(request, sendData);
		//跳转支付界面
		return "pay";	
	}
	//接收返回数据
	public void backBank(){
		BackData backData = (BackData)model;
		boolean isOk=payService.checkDataBack(backData);
		if(isOk){
			//更新订单状态,用来测试
			forderService.updateStatusById(Integer.valueOf(201605006), 2);
			//根据用户邮箱，发送邮件
			String emailAddress=backData.getR8_MP().split(",")[0];
			emailUtil.sendEmail(emailAddress, backData.getR6_Order());
			//发送手机短信
			String phoneNum=backData.getR8_MP().split(",")[1];
			messageUtil.sendMessage(phoneNum, backData.getR6_Order());
		}
		
	}
}
