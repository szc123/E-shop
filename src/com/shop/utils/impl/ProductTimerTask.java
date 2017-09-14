package com.shop.utils.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;

import javax.annotation.Resource;
import javax.servlet.ServletContext;

import org.springframework.stereotype.Component;

import com.shop.model.Category;
import com.shop.model.Product;
import com.shop.service.CategoryService;
import com.shop.service.ProductService;
@Component
public class ProductTimerTask extends TimerTask {
	
	@Resource  
    private ProductService productService = null; //ע��productService  
    @Resource  
    private CategoryService categoryService = null; //ע��categoryService  
      
    private ServletContext application = null; //����һ��ServletContext������Ϊ���Ǹ����˺�̨���ݺ���Ҫ����application������  
      
    public void setApplication(ServletContext application) {  
        this.application = application; //ͨ�������������application����set��������Ϊ�������޷���application�����  
    } 
    
	public void run() {
		List<List<Product>> bigList = new ArrayList<List<Product>>(); //bigList�д��һ��װ��Category���list  
        // 1. ��ѯ���ȵ����  
       for(Category category : categoryService.queryByHot(true)) {  
           //�����ȵ����id��ȡ�Ƽ���Ʒ��Ϣ  
           List<Product> lst = productService.queryByCategoryId(category.getId());  
           bigList.add(lst); //��װ��category��list�ŵ�bigList��  
       }  
        // 2. �Ѳ�ѯ��bigList����application���ö���  
        application.setAttribute("bigList", bigList); //���������Ѿ��õ���application����  
	}

}
