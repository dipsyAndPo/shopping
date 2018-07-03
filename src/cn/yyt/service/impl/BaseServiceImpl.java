package cn.yyt.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;

import cn.yyt.pojo.Category;
import cn.yyt.service.BaseService;
import cn.yyt.util.Page;

public class BaseServiceImpl extends ServiceDelegateDAO implements BaseService{

	
	
	protected Class clazz;

	
	public BaseServiceImpl() {
		try {
			throw new Exception();
		} catch (Exception e) {
			StackTraceElement[] stackTrace = e.getStackTrace();
			String className = stackTrace[1].getClassName();
			String a= className.replaceAll("ServiceImpl","");
			String b=a.replaceAll("service.impl", "pojo");
			try {
				clazz= Class.forName(b);
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		/*
		 try{
	            throw new Exception(); 
	        }
	        catch(Exception e){
	            StackTraceElement stes[]= e.getStackTrace();
	            String serviceImpleClassName=   stes[1].getClassName();
	            try {
	                Class  serviceImplClazz= Class.forName(serviceImpleClassName);
	                String serviceImpleClassSimpleName = serviceImplClazz.getSimpleName();
	                String pojoSimpleName = serviceImpleClassSimpleName.replaceAll("ServiceImpl", "");
	                String pojoPackageName = serviceImplClazz.getPackage().getName().replaceAll(".service.impl", ".pojo");
	                String pojoFullName = pojoPackageName +"."+ pojoSimpleName;
	                clazz=Class.forName(pojoFullName);
	            } catch (ClassNotFoundException e1) {
	                e1.printStackTrace();
	            }
	        } */     
	}

	@Override
	public List<Object> findAll() {
		DetachedCriteria dc=DetachedCriteria.forClass(Category.class);
		dc.addOrder(Order.desc("id"));
		return findByCriteria(dc);
	}


	@Override
	public Category get(int id) {
		return (Category) get(clazz, id);
	}


	@Override
	public Integer add(Object object) {
		return (Integer)save(object);
	}

	@Override
	public List findByPage(Page page) {
		DetachedCriteria dc=DetachedCriteria.forClass(Category.class);
		dc.addOrder(Order.desc("id"));
		return findByCriteria(dc, page.getStart(), page.getCount());
	}

	@Override
	public int gettotal() {
		List find = find("from Category");
		return find.size();
	}

	@Override
	public Object get(Class clazz, int id) {
		return super.get(clazz, id);
	}

}
