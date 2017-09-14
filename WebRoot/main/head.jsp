<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
     <%@ include file="/public/head.jspf" %>
  </head>
  <body>
    <div class="header">
            <div class="header_container">
                <!--头部开始-->
                        <div class="top_bar clear">
                            <!--头部小导航-->
                            <div class="welcom fl">欢迎光临LEISUPET SHOP! </div>
                            <ul class="top_links fr">
                                <li class="highlight"><a href="#">首页</a></li>
                                <li><a href="#">我的账户</a></li>
                                <li><a href="#">购物车</a></li>
                                <li><a href="#">注册</a></li>
                                <li ><a href="ulogin.jsp">登录</a></li>
                            </ul>
                            <!--头部小导航结束-->
                            <!-- logo -->
                            <h1 class="logo clear fl"> <a href="index.html"><img src="${shop }/images/logo.png" /></a> </h1>
                            <!-- 购物车 -->
                            <div class="minicart">
                                <a class="minicart_link" href="#">
                                    <span class="item">
                                        <b>${fn:length(sessionScope.forder.sorders)}</b> 件/
                                    </span>
                                    <span class="price">
                                        <b>￥${sessionScope.forder.total}</b>
                                    </span>
                                </a>
                            </div>
                            <!-- 购物车结束 -->
                            <!-- 搜索框 -->
                            <div class="header_search">
                                <div class="form-search ">
                                    <input  placeholder="请输入商品名称" class="input-text"  type="text"/>
                                    <button type="submit" title="Search"></button>
                                </div>
                            </div>
                   
                        </div>
                    
            </div>
        </div>
  </body>
</html>
