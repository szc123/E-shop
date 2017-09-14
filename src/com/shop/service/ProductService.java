package com.shop.service;

import java.util.List;

import com.shop.model.Product;

public interface ProductService extends BaseService<Product> {
	//��ѯ��Ʒ��Ϣ���������
	public List<Product> queryJoinCategory(String name, int page, int size);
	//���ݹؼ��ֲ�ѯ��¼����
	public Long getCount(String name);
	//����idɾ����¼
	public void deleteByIds(String ids);
	//�����ȵ��ѯ�Ƽ���Ʒ��4����
	public List<Product> queryByCategoryId(int cid);
}
