package com.shop.utils.impl;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;
import org.springframework.stereotype.Component;

import com.shop.utils.MessageUtil;
@Component("messageUtil")
public class MessageUtilImpl implements MessageUtil {

	public void sendMessage(String phoneNum, String id) {
		//1.�������
		HttpClient client=new HttpClient();
		//2.��������ʽ
		PostMethod post=new PostMethod("http://utf8.sms.webchinese.cn/");
		//3.��������Ĳ���
		post.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");
		post.setParameter("Uid", "eson_15");
	    post.setParameter("Key", "0537729d0b59a7e7358b");
	    post.setParameter("smsMob", "15216771570");
	    post.setParameter("smsText", "����һ�£�");
	    //4.�ύ������״̬��
	    try {
			int code=0;
			code=client.executeMethod(post);
			System.out.println("http���ص�״̬��"+code);
			//5.��ȡ����˷��ص���Ϣ
			String result=post.getResponseBodyAsString();
			System.out.println("���ŷ��ͽ��Ϊ"+result);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		} finally {
			post.releaseConnection();
		}
	}
}
