package com.ifox.smartbluetooth.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ifox.smartbluetooth.dao.BaseDao;
import com.ifox.smartbluetooth.domain.BaseEntity;
import com.ifox.smartbluetooth.utils.DaoUtil;

@Repository("baseDao")
public class BaseDaoImpl<T extends BaseEntity> implements BaseDao{

	@Autowired
	private  DaoUtil daoUtil;
	
 
	@SuppressWarnings("unchecked")
	public List<T> find(String hql, Object[] paras) throws Exception {
		return (List<T>)daoUtil.getListByHql(hql,paras);
	}

	@SuppressWarnings("unchecked")
	public List<T> findBySQL(String sql) throws Exception {
		return (List<T>)daoUtil.getListBySQL(sql);
	}

	public void save(BaseEntity entity) throws Exception {
		 daoUtil.getSession().save(entity);
	}

	public void delete(BaseEntity entity) throws Exception {
		daoUtil.getSession().delete(entity);
	}

	public void update(BaseEntity entity) throws Exception {
		daoUtil.getSession().update(entity);
	}

}
