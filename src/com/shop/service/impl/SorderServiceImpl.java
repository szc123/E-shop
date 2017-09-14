package com.shop.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import com.shop.model.Forder;
import com.shop.model.Product;
import com.shop.model.Sorder;
import com.shop.service.SorderService;
@Service("sorderService")
public class SorderServiceImpl extends BaseServiceImpl<Sorder> implements
		SorderService {
	public Forder addSorder(Forder forder, Product product) {
		boolean isHave=false;//标记有没有重复的购物项
		//拿到当前购物项
		Sorder sorder=productToSorder(product);
		for (Sorder old : forder.getSorders()) {
			if(old.getProduct().getId().equals(sorder.getProduct().getId())){
				//购物项有重复，添加数量
				old.setNumber(old.getNumber()+sorder.getNumber());
				isHave=true;
				break;
			}
		}
		//没有这个购物项，添加购物项
		if(!isHave){
			sorder.setForder(forder);
			forder.getSorders().add(sorder);
		}
		return forder;
	}
	//把商品加到购物项
	public Sorder productToSorder(Product product) {
		Sorder sorder=new Sorder();
		sorder.setName(product.getName());
		sorder.setNumber(1);
		sorder.setPrice(product.getPrice());
		sorder.setProduct(product);
		return sorder;
	}
	public Forder updateSorder(Sorder sorder, Forder forder) {
		for (Sorder temp:forder.getSorders()) {
			if(temp.getProduct().getId().equals(sorder.getProduct().getId())){
				temp.setNumber(sorder.getNumber());
			}
		}
		return forder;
	}
	public List<Object> querySale(int number) {
		String hql="select s.name,sum(s.number) from Sorder s join s.product group by s.product.id";
		return getSession().createQuery(hql).setFirstResult(0)
				.setMaxResults(number).list();
	}
}
