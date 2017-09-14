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
		//判断当前session是否有用户信息
		if(req.getSession().getAttribute("user")==null){
			//保存用户要去的地址
			String goUrl=req.getServletPath();//获得要去的路径
			String param=req.getQueryString();//获得路径中带的参数
			if(param!=null){
				goUrl=goUrl+"?"+param;
			}
			//保存用户要去的地址到session中
			req.getSession().setAttribute("goUrl", goUrl);
			//非法请求，跳转登陆界面
			req.getSession().setAttribute("error", "您还没有登陆，请先登录");
			res.sendRedirect(req.getContextPath()+"/ulogin.jsp");
		}else{
			chain.doFilter(request, response);
		}
		
	}

	public void init(FilterConfig arg0) throws ServletException {

	}

}
