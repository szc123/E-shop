package com.shop.service;

import com.shop.model.Forder;

public interface ForderService extends BaseService<Forder> {
	//计算购物总价
	public double cluTotal(Forder forder);
	//根据订单编号，更新订单状态
    public void updateStatusById(int id, int sid);
}
