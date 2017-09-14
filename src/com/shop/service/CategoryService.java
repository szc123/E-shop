package com.shop.service;

import java.util.List;

import com.shop.model.Category;

public interface CategoryService extends BaseService<Category>{
	//��ѯ�����Ϣ���������Ա
	public List<Category> queryJoinAccount(String type, int page, int size);//������Ʋ�ѯ

	public Long getCount(String type);
	
	public void deleteByIds(String ids);
	//�����ȵ��ѯ���
	public List<Category> queryByHot(boolean hot);
	
}
