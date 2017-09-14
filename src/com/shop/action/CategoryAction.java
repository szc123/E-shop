package com.shop.action;

import java.io.ByteArrayInputStream;
import java.util.HashMap;
import java.util.List;

import net.sf.json.JSONObject;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.shop.model.Category;
@Controller("categoryAction")
@Scope("prototype")
public class CategoryAction extends BaseAction<Category> {
	private static final long serialVersionUID = 1L;
	public void update(){
		categoryService.update(model);
	}
	public void save() {
		categoryService.save(model);
	}
	public String query(){
		jsonList=categoryService.query();
		return "jsonList";
	}
	public String queryJoinAccount(){
		pageMap=new HashMap<String, Object>();
		List<Category> categoryList=categoryService.queryJoinAccount(model.getType(), page, rows);
		pageMap.put("rows", categoryList);
		Long total=categoryService.getCount(model.getType());
		pageMap.put("total", total);
		return "jsonMap";
	}
	public String deleteByIds(){
		categoryService.deleteByIds(ids);
		inputStream=new ByteArrayInputStream("true".getBytes());
		return "stream";	
	}
}
