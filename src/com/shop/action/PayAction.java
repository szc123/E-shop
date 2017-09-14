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
	
	
	//����һ��Map����request�������
	private Map<String, String[]> parameters;
	@Override
	public void setParameters(Map<String, String[]> parameters) {
		this.parameters=parameters;
	}
	//�ж����ĸ����� ----- ServletConfig��������ModelDriven֮ǰ��ִ�У�����������ע��model��ʱ��
    //request�����Ѿ����ˣ��������ǾͿ�����getModel()������ͨ���������ж����ĸ�������
	@Override
	public Object getModel() {
		//�����ʱ����֧��ͨ������Ĳ���(pd_FrpId)�����ص�ʱ��û��
	    //�������ǾͿ���ͨ���ò����ж���֧�����Ƿ�����
		if(parameters.get("pd_FrpId")!=null){
			model=new SendData();
		}else{
			model=new BackData();
		}
		return model;
	}
	//���ױ���������
	public String goBank(){
		Forder forder=(Forder) session.get("forder");
		User user=(User) session.get("user");
		SendData sendData = (SendData)model;
		sendData.setP2_Order(forder.getId().toString());
		sendData.setP3_Amt(forder.getTotal().toString());
		sendData.setPa_MP(user.getEmail()+","+user.getPhone());
		//�浽request����
		payService.saveDataToRequest(request, sendData);
		//��ת֧������
		return "pay";	
	}
	//���շ�������
	public void backBank(){
		BackData backData = (BackData)model;
		boolean isOk=payService.checkDataBack(backData);
		if(isOk){
			//���¶���״̬,��������
			forderService.updateStatusById(Integer.valueOf(201605006), 2);
			//�����û����䣬�����ʼ�
			String emailAddress=backData.getR8_MP().split(",")[0];
			emailUtil.sendEmail(emailAddress, backData.getR6_Order());
			//�����ֻ�����
			String phoneNum=backData.getR8_MP().split(",")[1];
			messageUtil.sendMessage(phoneNum, backData.getR6_Order());
		}
		
	}
}
