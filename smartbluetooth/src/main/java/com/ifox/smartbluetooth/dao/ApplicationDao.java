package com.ifox.smartbluetooth.dao;

import java.util.List;

import com.ifox.smartbluetooth.domain.Application;

public interface ApplicationDao {
	
	void save(Application application) throws Exception;
    List<Application> findCheckingApplictionByFlag(Integer uid) throws Exception;
}
