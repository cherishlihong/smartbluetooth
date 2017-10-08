package com.ifox.smartbluetooth.utils;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ifox.smartbluetooth.domain.Page;

@Repository
public class DaoUtil {
	@Autowired
	private SessionFactory sessionFactory;
	private Session session;
	
	public Session getSession() {
		this.setSession();
		if (session==null) {
			this.session=sessionFactory.openSession();
		}
		return session;
	}
	public void setSession() {
		this.session = sessionFactory.getCurrentSession();
	}
	
	public List getListByHql(String hql,Object[] params) {
		Session session = this.getSession();
		Query query = session.createQuery(hql);
		if (params!=null&&params.length>0) {
			for(int i=0;i<params.length;i++){
				query.setParameter(i, params[i]);
			}
			return query.list();
		}else {
			return query.list();
		}
	}
	
	public List getListBySQL(String sql){
		Session session = this.getSession();
		SQLQuery query = session.createSQLQuery(sql);
		return query.list();
		}
	
	public List getListByPage(String hql){
		Session session = this.getSession();
		Query query = session.createQuery(hql);
		query.setMaxResults(10);
		return query.list();
	}
	
	public int  getTotal(String sql) {
		Session session = this.getSession();
		SQLQuery query = session.createSQLQuery(sql);
		return query.list().size();
	}
	
	public List getAll(String hql) {
		Session session = this.getSession();
		Query query = session.createQuery(hql);
		return query.list();
	}
	
	public Page getResultByPage(String hql,Page page) {
		Session session = this.getSession();
		Query query = session.createQuery(hql);
		int start = 0;
		int pageNo = page.getPageSize();
		int pageSize = page.getPageSize();
		if (pageNo>1&&pageSize==15) {
			start = pageSize*pageNo-15;
		}
		if (pageNo>1&&pageSize==10) {
			start = (pageNo-1)*pageSize;
		}
		if (pageNo==0||pageNo==1) {
			start=0;
		}
		query.setFirstResult(start);
		query.setMaxResults(page.getPageSize());
		List list = query.list();
		page.setList(list);
		return page;
	}
}
