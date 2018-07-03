package cn.yyt.service;

import java.util.List;

import cn.yyt.util.Page;

public interface BaseService {
	//查询全部
		public List<Object> findAll();
		//删除
		public void delete(Object object);
		//查询一个用于修改
		public Object get(int id);
		//查询一个用于修改
		public Object get(Class clazz,int id);
		//修改
		public void update(Object object);
		//添加
		public Integer add(Object object);
		//通过page查询一页
		public List findByPage(Page page);
		//获取总共的数量
		public int gettotal();
}
