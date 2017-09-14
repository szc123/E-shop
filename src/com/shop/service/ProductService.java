package com.shop.service;

import java.util.List;

import com.shop.model.Product;

public interface ProductService extends BaseService<Product> {
	//查询商品信息，级联类别
	public List<Product> queryJoinCategory(String name, int page, int size);
	//根据关键字查询记录总数
	public Long getCount(String name);
	//根据id删除记录
	public void deleteByIds(String ids);
	//根据热点查询推荐产品（4个）
	public List<Product> queryByCategoryId(int cid);
}
