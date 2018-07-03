package cn.yyt.dao.impl;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

@Repository("dao")
public class DaoImpl extends HibernateTemplate{
	
	//¸øDao°ü×¢ÈësessionFactory
	@Resource(name="sf")
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}
}
