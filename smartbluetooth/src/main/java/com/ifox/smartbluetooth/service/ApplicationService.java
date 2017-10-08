package com.ifox.smartbluetooth.service;

import java.util.List;

import com.ifox.smartbluetooth.domain.Application;
import com.ifox.smartbluetooth.domain.LogRecord;

public interface ApplicationService {
	
	void save(Application application) throws  Exception;

	List<Application> findSuccessApplicateByUid(Integer uid) throws  Exception;
	List<Application> findCheckingApplictionByFlag(Integer uid) throws Exception;
}
