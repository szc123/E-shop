package com.shop.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import com.shop.model.Category;
import com.shop.service.CategoryService;
@Service("categoryService")
public class CategoryServiceImpl extends BaseServiceImpl<Category> implements CategoryService {
	// µœ÷∑÷“≥
	public List<Category> queryJoinAccount(String type, int page, int size) {
		String hql="from Category c left join fetch c.account where c.type like :type";
		return getSession().createQuery(hql)
							.setString("type", "%"+type+"%")
							.setFirstResult((page-1)*size)
							.setMaxResults(size)
							.list();
	}
	public Long getCount(String type) {
		String hql="select count(c) from Category c where c.type like :type";
		return (Long) getSession().createQuery(hql)
				.setString("type", "%"+type+"%")
				.uniqueResult();
	}
	public void deleteByIds(String ids) {
		String hql="delete from Category c where c.id in ("+ids+")";
		getSession().createQuery(hql).executeUpdate();
	}
	public List<Category> queryByHot(boolean hot) {
		String hql="from Category c where c.hot=:hot";
		return getSession().createQuery(hql).setBoolean("hot", hot).list();
	}	
}
