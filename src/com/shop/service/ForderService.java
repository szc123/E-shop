package com.shop.service;

import com.shop.model.Forder;

public interface ForderService extends BaseService<Forder> {
	//���㹺���ܼ�
	public double cluTotal(Forder forder);
	//���ݶ�����ţ����¶���״̬
    public void updateStatusById(int id, int sid);
}
