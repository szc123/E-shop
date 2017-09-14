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
			//����session�Ự
			session=Session.getDefaultInstance(prop);
			//����debug������
			session.setDebug(true);
			//����һ���ʼ�����
			message=new MimeMessage(session);
			//д��
			message.setSubject("�����̳Ƕ���");
			//��������
			message.setContent("�˿����ã���ӭ����������̳ǣ�����" + id + "��֧���ɹ���", "text/html;charset=utf-8");
			//�����˵�ַ
			message.setFrom(new InternetAddress("soft03_test@sina.com"));
			transport=session.getTransport();
			//�����ʼ�����������֤
			transport.connect("smtp.sina.com", "soft03_test", "soft03_test");
			//�����ռ��˵�ַ�������ʼ�
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
