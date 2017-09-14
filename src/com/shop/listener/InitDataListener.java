package com.shop.listener;

import java.util.Timer;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.shop.utils.FileUpload;
import com.shop.utils.impl.ProductTimerTask;

public class InitDataListener implements ServletContextListener{
	
	  private ProductTimerTask productTimerTask = null;
	  private ApplicationContext context = null;  
	  private FileUpload fileUpload=null;
	@Override
	public void contextDestroyed(ServletContextEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		context=WebApplicationContextUtils.getWebApplicationContext(event.getServletContext());
		productTimerTask = (ProductTimerTask) context.getBean("productTimerTask");//�������ļ��л�ȡProductTimerTask����  
		  
        //�����ö��󽻸�productTimerTask,��ΪproductTimerTask�������ò���application�ģ�ֻ��ͨ��������set����  
        productTimerTask.setApplication(event.getServletContext());  
  
        //ͨ�����ö�ʱ��������ҳ������ÿ��һСʱͬ��һ�Σ�����Ϊ�ػ��̣߳�  
        new Timer(true).schedule(productTimerTask, 0, 1000*60*60);//ÿ��һСʱִ��һ��productTimerTask���񣬼�����һ�º�̨���� 
        
        fileUpload=(FileUpload) context.getBean("fileUpload");
        event.getServletContext().setAttribute("bankImageList", fileUpload.getBankImage());
	}

}
