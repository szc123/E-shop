package com.shop.action;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.shop.model.Product;
@Controller("productAction")
@Scope("prototype")
public class ProductAction extends BaseAction<Product> {

	private static final long serialVersionUID = 1L;
	
	public String queryJoinCategory(){
		pageMap=new HashMap<String, Object>();
		List<Product> productList=productService.queryJoinCategory(model.getName(), page, rows);
		pageMap.put("rows", productList);
		Long total=productService.getCount(model.getName());
		pageMap.put("total", total);
		return "jsonMap";
	}
	public String deleteByIds(){
		productService.deleteByIds(ids);
		inputStream=new ByteArrayInputStream("true".getBytes());
		return "stream";
	}
	public void save() throws IOException{
		String pic=fileUpload.uploadFile(fileImage);
		model.setPic(pic);
		model.setDate(new Date());
		productService.save(model);
	}
	public void update(){
		String pic=fileUpload.uploadFile(fileImage);
		model.setPic(pic);
		model.setDate(new Date());
		productService.update(model);
	}
	
}
