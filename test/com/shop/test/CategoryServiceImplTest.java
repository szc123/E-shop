package com.shop.test;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.shop.model.Category;
import com.shop.service.CategoryService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:beans.xml")
public class CategoryServiceImplTest {
	
	@Resource
	private CategoryService categoryService;
	//@Test
	public void testQueryJoinAccount(){
		
		for (Category c : categoryService.queryJoinAccount("",1,10)) {
			System.out.println(c.getType());
			System.out.println(c.getAccount().getName());
		}
	}
	@Test
	public void addCategory(){
		Category c=new Category("าย",true);
		categoryService.save(c);
		
	}
	//@Test
	public void query(){
		List<Category> list=categoryService.query();
		for (Category category : list) {
			System.out.println(category.getType());
		}
	}
}
