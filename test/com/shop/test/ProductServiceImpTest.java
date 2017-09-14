package com.shop.test;

import java.util.List;

import javax.annotation.Resource;

import net.sf.json.JSONSerializer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.shop.model.Category;
import com.shop.model.Product;
import com.shop.service.ProductService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:beans.xml")
public class ProductServiceImpTest {
	@Resource
	private ProductService productService;
	//@Test
	public void testQueryJoinCategory(){
		List<Product> list=productService.queryJoinCategory("", 1, 5);
		for (Product product : list) {
			System.out.println(product.getName());
			System.out.println(product.getCategory());
			System.out.println(JSONSerializer.toJSON(product));
		}
	}
	//@Test
	public void getCount(){
		Long total=productService.getCount("");
		System.out.println(total);
	}
	@Test
	public void testSave(){
		Category c=new Category();
		c.setId(5);
		Product p=new Product();
		p.setName("哈哈哈");
		p.setPrice(2399.9);
		p.setCategory(c);
		p.setRemark("就阿斯达斯");
		productService.save(p);
	}
}
