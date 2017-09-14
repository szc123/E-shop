package com.shop.test;

import java.util.Date;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.shop.model.Category;
import com.shop.service.CategoryService;
import com.shop.service.impl.CategoryServiceImpl;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:beans.xml")
public class SSHTest {
	/*@Resource
	private Date date;*/
	@Resource
	private CategoryService categoryService;
	/*@Test
	public void springIOC(){
		System.out.println(date);
	}
	@Test
	public void hibernate(){
		CategoryService categoryService=new CategoryServiceImpl();
		Category category=new Category("ÄÐÊ¿ÐÝÏÐ",true);
		categoryService.save(category);
	}*/
	@Test
	public void update(){
		categoryService.update(new Category(1,"ÐÝÏÐÅ®Ê¿", true));
	}
}
