package com.shop.service.impl;

import org.springframework.stereotype.Service;
import com.shop.model.Forder;
import com.shop.model.Sorder;
import com.shop.service.ForderService;
@Service("forderService")
public class ForderServiceImpl extends BaseServiceImpl<Forder> implements ForderService {
	//计算购物车总价
	public double cluTotal(Forder forder) {
		double total=0;
		for (Sorder sorder : forder.getSorders()) {
			total+=sorder.getNumber() * sorder.getPrice();
		}
		return total;
	}

	public void updateStatusById(int id, int sid) {
		String hql="update Forder f set f.status.id=:sid where f.id=:id";
		getSession().createQuery(hql)
					.setInteger("sid", sid)
					.setInteger("id", id)
					.executeUpdate();
	}
}
