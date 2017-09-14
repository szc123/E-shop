package com.shop.utils.impl;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;
import org.springframework.stereotype.Component;

import com.shop.utils.MessageUtil;
@Component("messageUtil")
public class MessageUtilImpl implements MessageUtil {

	public void sendMessage(String phoneNum, String id) {
		//1.打开浏览器
		HttpClient client=new HttpClient();
		//2.创建请求方式
		PostMethod post=new PostMethod("http://utf8.sms.webchinese.cn/");
		//3.设置请求的参数
		post.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");
		post.setParameter("Uid", "eson_15");
	    post.setParameter("Key", "0537729d0b59a7e7358b");
	    post.setParameter("smsMob", "15216771570");
	    post.setParameter("smsText", "测试一下！");
	    //4.提交并返回状态码
	    try {
			int code=0;
			code=client.executeMethod(post);
			System.out.println("http返回的状态吗"+code);
			//5.获取服务端返回的信息
			String result=post.getResponseBodyAsString();
			System.out.println("短信发送结果为"+result);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		} finally {
			post.releaseConnection();
		}
	}
}
