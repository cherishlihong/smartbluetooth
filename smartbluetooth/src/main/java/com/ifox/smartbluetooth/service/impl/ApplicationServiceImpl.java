package com.ifox.smartbluetooth.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ifox.smartbluetooth.dao.ApplicationDao;
import com.ifox.smartbluetooth.domain.Application;
import com.ifox.smartbluetooth.domain.LogRecord;
import com.ifox.smartbluetooth.service.ApplicationService;

@Service("applicationService")
public class ApplicationServiceImpl implements ApplicationService {

	@Autowired
	private ApplicationDao applicationDao;
	public void save(Application application) throws Exception {
		
		applicationDao.save(application) ;
	}
	public List<Application> findSuccessApplicateByUid(Integer uid) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	public List<Application> findCheckingApplictionByFlag(Integer uid) throws Exception {
		return applicationDao.findCheckingApplictionByFlag(uid);
	}

}
