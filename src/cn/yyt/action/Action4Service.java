package cn.yyt.action;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.apache.commons.lang.xwork.WordUtils;
import org.springframework.beans.factory.annotation.Autowired;

import cn.yyt.service.CategoryService;

public class Action4Service extends Action4Pojo{
	@Autowired
	CategoryService categoryService;
	
	/**
	 * transient to persistent
	 * 瞬时对象转换为持久对象
	 * @param o
	 */
	public void t2p(Object o){
		Class clazz = o.getClass();
		try {
			//通过反射获取id
			int id=(Integer)clazz.getMethod("getId").invoke(o);
			//用过id获取到持久态对象
			Object object = categoryService.get(clazz,id);
			//获取pojo的名称
			String beanSimpleName = clazz.getSimpleName();
			//运行set+pojo名称的方法，把持久态对象赋值给javabean
			Method method = getClass().getMethod("set"+WordUtils.capitalize(beanSimpleName), clazz);
			method.invoke(this,object);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
