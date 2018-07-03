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
	 * ˲ʱ����ת��Ϊ�־ö���
	 * @param o
	 */
	public void t2p(Object o){
		Class clazz = o.getClass();
		try {
			//ͨ�������ȡid
			int id=(Integer)clazz.getMethod("getId").invoke(o);
			//�ù�id��ȡ���־�̬����
			Object object = categoryService.get(clazz,id);
			//��ȡpojo������
			String beanSimpleName = clazz.getSimpleName();
			//����set+pojo���Ƶķ������ѳ־�̬����ֵ��javabean
			Method method = getClass().getMethod("set"+WordUtils.capitalize(beanSimpleName), clazz);
			method.invoke(this,object);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
