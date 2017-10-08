package com.ifox.smartbluetooth.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ifox.smartbluetooth.dao.ApplicationDao;
import com.ifox.smartbluetooth.dao.BaseDao;
import com.ifox.smartbluetooth.domain.Application;
import com.ifox.smartbluetooth.domain.AuthorizeRecord;
import com.ifox.smartbluetooth.utils.ValueUtil;

@Repository("applicationDao")
public class ApplicationDaoImpl implements ApplicationDao {
	@Autowired
	private BaseDao<Application> baseDao;
	
	public void save(Application application) throws Exception {
		
		baseDao.save(application);
	}

	public List<Application> findCheckingApplictionByFlag(Integer uid) throws Exception {
		String hql = "from Application app where app.user.uid=? and flag=0";
		Object[] paramObjs = {uid};
		List<Application> applications = baseDao.find(hql,paramObjs);
		if (ValueUtil.isNotNullList(applications)) {
			return applications;
		}
		return null;
	}

}
