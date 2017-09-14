package com.shop.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserFilter implements Filter {

	public void destroy() {

	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req=(HttpServletRequest) request;
		HttpServletResponse res=(HttpServletResponse) response;
		//�жϵ�ǰsession�Ƿ����û���Ϣ
		if(req.getSession().getAttribute("user")==null){
			//�����û�Ҫȥ�ĵ�ַ
			String goUrl=req.getServletPath();//���Ҫȥ��·��
			String param=req.getQueryString();//���·���д��Ĳ���
			if(param!=null){
				goUrl=goUrl+"?"+param;
			}
			//�����û�Ҫȥ�ĵ�ַ��session��
			req.getSession().setAttribute("goUrl", goUrl);
			//�Ƿ�������ת��½����
			req.getSession().setAttribute("error", "����û�е�½�����ȵ�¼");
			res.sendRedirect(req.getContextPath()+"/ulogin.jsp");
		}else{
			chain.doFilter(request, response);
		}
		
	}

	public void init(FilterConfig arg0) throws ServletException {

	}

}
