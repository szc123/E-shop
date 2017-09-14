package com.shop.service;

import java.util.List;

import com.shop.model.Category;

public interface CategoryService extends BaseService<Category>{
	//查询类别信息，级别管理员
	public List<Category> queryJoinAccount(String type, int page, int size);//类别名称查询

	public Long getCount(String type);
	
	public void deleteByIds(String ids);
	//根据热点查询类别
	public List<Category> queryByHot(boolean hot);
	
}
