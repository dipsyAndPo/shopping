package cn.yyt.test;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import cn.yyt.dao.impl.DaoImpl;
import cn.yyt.pojo.Category;
import cn.yyt.service.CategoryService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestTmall {
	@Autowired
	DaoImpl dao;
	@Autowired
	CategoryService cs;
	
//	@Test
//	public void delete(){
//		DetachedCriteria dc = DetachedCriteria.forClass(Category.class);
//		List<Category> cs = dao.findByCriteria(dc);
//		for (Category c : cs) {
//			dao.delete(c);
//		}
//	}
	
	@Test
	public void test(){
		
		List<Category> findAll = dao.find("from Category");
		for (Category category : findAll) {
			System.out.println(category);
		}
		
//		DetachedCriteria dc = DetachedCriteria.forClass(Category.class);
//		List<Category> cs = dao.findByCriteria(dc);
//		if (cs.isEmpty()) {
//			for (int i = 0; i < 100; i++) {
//				Category c=new Category();
//				c.setName("测试分类"+i);
//				dao.save(c);
//			}
//			System.out.println("成功添加10个测试类");
//		}
	}

}
