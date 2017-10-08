package com.ifox.smartbluetooth.dao;

import java.util.List;

import com.ifox.smartbluetooth.domain.BaseEntity;

public interface BaseDao<T extends BaseEntity> {
	
	List<T> find(String hql,Object[] params) throws Exception;
	List<T> findBySQL(String sql) throws Exception;
	
	void save(BaseEntity entity) throws Exception;//保内保外子包可以访问
	void delete(BaseEntity entity) throws Exception;
	void update(BaseEntity entity) throws Exception;
}
