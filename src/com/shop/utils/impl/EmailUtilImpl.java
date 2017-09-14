package com.shop.utils.impl;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Component;

import com.shop.utils.EmailUtil;
@Component("emailUtil")
public class EmailUtilImpl implements EmailUtil {

	public void sendEmail(String emailAddress, String id) {
		Properties prop=new Properties();
		Session session=null;
		Message message=null;
		Transport transport=null;
		try {
			prop.setProperty("mail.transport.protocol", "smtp");
			//创建session会话
			session=Session.getDefaultInstance(prop);
			//设置debug来调试
			session.setDebug(true);
			//创建一份邮件对象
			message=new MimeMessage(session);
			//写信
			message.setSubject("网上商城订单");
			//正文内容
			message.setContent("顾客您好，欢迎您光顾网上商城，订单" + id + "已支付成功！", "text/html;charset=utf-8");
			//附件人地址
			message.setFrom(new InternetAddress("soft03_test@sina.com"));
			transport=session.getTransport();
			//连接邮件服务器的认证
			transport.connect("smtp.sina.com", "soft03_test", "soft03_test");
			//设置收件人地址，发送邮件
			transport.sendMessage(message, new InternetAddress[] { new InternetAddress(emailAddress) });
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			try {
				transport.close();
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		}
	}
}
