package cn.yyt.service;

import java.util.List;

import cn.yyt.util.Page;

public interface BaseService {
	//��ѯȫ��
		public List<Object> findAll();
		//ɾ��
		public void delete(Object object);
		//��ѯһ�������޸�
		public Object get(int id);
		//��ѯһ�������޸�
		public Object get(Class clazz,int id);
		//�޸�
		public void update(Object object);
		//���
		public Integer add(Object object);
		//ͨ��page��ѯһҳ
		public List findByPage(Page page);
		//��ȡ�ܹ�������
		public int gettotal();
}
