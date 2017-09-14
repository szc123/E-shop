<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<%@ include file="/public/head.jspf" %>
  </head>
  
  <body>
  	<div class="wrapper">
        <!-- 头部开始 -->
        <%@ include file="/main/head.jsp" %>
        <!-- 头部结束 -->

        <!-- 导航栏 -->
        <div class="navigation_container">
        <!---->
         <div class="nav">
            <ul class="primary_nav">
                <li class="active highlight"><a href="#">女装</a>
                    <!--二级菜单-->
                    <ul class="sub_menu">
                        <li > <a href="#">裙装</a>
                            <ul>
                                <li><a href="#">短裙</a></li>
                                <li><a href="#">短裤 </a></li>
                                <li><a href="#">裤子</a></li>
                                <li><a href="#">卡其裤</a></li>
                                <li><a href="#">休闲裤</a></li>
                                <li><a href="#">牛仔裤</a></li>
                                <li><a href="#">风衣 & 运动夹克</a></li>
                            </ul>
                        </li>
                        <li> <a href="#">装饰品 </a>
                            <ul>
                                <li><a href="#"> 太阳镜</a></li>
                                <li><a href="#">围巾 </a></li>
                                <li><a href="#">发饰品 </a></li>
                                <li><a href="#">帽子和手套 </a></li>
                                <li><a href="#">生活时尚 </a></li>
                                <li><a href="#">牛仔系列 </a></li>
                                <li><a href="#">风衣 & 西服</a></li>
                            </ul>
                        </li>
                    </ul>
                </li>
                    <!--二级菜单结束-->
                
                <li><a href="#">男装</a>
                    <!--二级菜单-->
                    <ul class="sub_menu">
                        <li> <a href="#">男士夏装</a>
                            <ul>
                                <li><a href="#">裤子</a></li>
                                <li><a href="#">休闲裤</a></li>
                                <li><a href="#">卡其裤</a></li>
                                <li><a href="#">牛仔裤</a></li>
                                <li><a href="#">风衣 & 运动夹克</a></li>
                            </ul>
                        </li>
                         <li> <a href="#">装饰品 </a>
                            <ul>
                                <li><a href="#"> 太阳镜</a></li>
                                <li><a href="#">围巾 </a></li>
                                <li><a href="#">发饰品 </a></li>
                                <li><a href="#">帽子和手套 </a></li>
                                <li><a href="#">生活时尚 </a></li>
                                <li><a href="#">牛仔系列 </a></li>
                                <li><a href="#">风衣 & 西服</a></li>
                            </ul>
                        </li>
                    </ul>
                    <!--二级菜单结束-->
                </li>
                <li><a href="#">儿童</a></li>
                <li><a href="#">时尚</a></li>
                <li><a href="#">装饰品 </a></li>
            </ul>
        </div>
        </div>
        <!--导航栏结束-->

        
        <div class="section_container">
            <!--左侧导航-->
            <div id="side_nav">
                <div class="sideNavCategories">
                    <h1>女装</h1>
                    <ul class="category departments">
                        <li class="header">分类</li>
                        <li><a href="#">毛衣</a></li>
                        <li><a href="#">针织衫 </a></li>
                        <li><a href="#">衬衫 </a></li>
                        <li><a href="#">T恤</a></li>
                        <li><a href="#">短裤</a></li>
                        <li><a href="#">牛仔 </a></li>
                        <li><a href="#">连身裙</a></li>
                        <li><a href="#">短裙 </a></li>
                    </ul>
                </div>
                
            </div>
            <!-- 右侧焦点图区域 -->
            <div id="main_content ">
                <div > <img src="images/lm_banner_1.jpg" /> </div>
            </div>
        </div>


            <!-- 产品列表 -->            
            <div class="products_list products_slider clear">
                <h2 class="sub_title">新品发售</h2>
                <ul id="first-carousel" class="first-and-second-carousel jcarousel-skin-tango">
                    <li> <a  href="#" class="product_image"><img src="images/pr_l_1.jpg" /></a>
                        <div class="product_info">
                            <h3><a href="#">夏季新品长裙</a></h3>
                            <small>印花 纯棉</small> </div>
                        <div class="price_info"> 
                            </button><button><span class="pr_add">添加购物车</span></button><button class="price_add" title="" type="button"><span class="pr_price">￥76.00</span>
                        </div>
                    </li>
                    <li> <a  href="#" class="product_image"><img src="images/pr_l_2.jpg" /></a>
                        <div class="product_info">
                            <h3><a href="#">夏季新品长裙</a></h3>
                            <small>印花 纯棉</small> </div>
                        <div class="price_info"> 
                            <button><span class="pr_add">添加购物车</span></button><button class="price_add" title="" type="button"><span class="pr_price">￥76.00</span></button>
                        
                        </div>
                    </li>
                    <li> <a  href="#" class="product_image"><img src="images/pr_l_3.jpg" /></a>
                        <div class="product_info">
                            <h3><a href="#">夏季新品长裙</a></h3>
                            <small>印花 纯棉</small> </div>
                        <div class="price_info"> 
                            <button><span class="pr_add">添加购物车</span></button><button class="price_add" title="" type="button"><span class="pr_price">￥76.00</span></button>
                        </div>
                    </li>
                    <li> <a  href="#" class="product_image"><img src="images/pr_l_5.jpg" /></a>
                        <div class="product_info">
                            <h3><a href="#">夏季新品长裙</a></h3>
                            <small>印花 纯棉</small> </div>
                        <div class="price_info"> 
                            <button><span class="pr_add">添加购物车</span></button><button class="price_add" title="" type="button"><span class="pr_price">￥76.00</span></button>
                        </div>
                    </li>
                    <li> <a  href="#" class="product_image"><img src="images/pr_l_1.jpg" /></a>
                        <div class="product_info">
                            <h3><a href="#">夏季新品长裙</a></h3>
                            <small>印花 纯棉</small> </div>
                        <div class="price_info"> 
                            <button><span class="pr_add">添加购物车</span></button><button class="price_add" title="" type="button"><span class="pr_price">￥76.00</span></button>
                        </div>
                    </li>
                    <li> <a  href="#" class="product_image"><img src="images/pr_l_2.jpg" /></a>
                        <div class="product_info">
                            <h3><a href="#">夏季新品长裙</a></h3>
                            <small>印花 纯棉</small> </div>
                        <div class="price_info"> 
                            <button><span class="pr_add">添加购物车</span></button><button class="price_add" title="" type="button"><span class="pr_price">￥76.00</span></button>
                        </div>
                    </li>
                </ul>
            </div>
            
            <!-- 产品列表开始 -->
            <c:forEach items="${applicationScope.bigList}" var="list">
	            <div class="products_list products_slider clear">
	            	<!-- 显示类别名称 -->
	                <h2 class="sub_title">${list[0].category.type}</h2>
	                <ul id="first-carousel" class="first-and-second-carousel jcarousel-skin-tango">
	                    <c:forEach items="${list }" var="product">
		                    <li> 
		                    	<a href="${shop}/product_get.action?id=${product.id}" class="product_image"><img src="${shop}/files/${product.pic}" /></a>
		                        <div class="product_info">
		                            <h3><a href="#">商品名称：${product.name }</a></h3>
		                            <small>简单描述：${product.remark}</small> </div>
		                        <div class="price_info"> 
		                            <a href="${shop}/sorder_addSorder.action?product.id=${product.id}"><button><span class="pr_add">添加购物车</span></button></a>
		                            <button class="price_add" title="" type="button">
		                            	<span class="pr_price">￥${product.price}</span>
		                            </button>
		                        </div>
		                    </li>
	                    </c:forEach>
	                </ul>
	            </div>
            </c:forEach>
            
            
        <!--产品列表结束  -->

        <!-- 导航栏结束 -->
       
        <%@  include file="/main/foot.jsp" %>
    </div>
  </body>
</html>
