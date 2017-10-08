package com.ifox.smartbluetooth.service;

import java.util.List;

import com.ifox.smartbluetooth.domain.AuthorizeRecord;

public interface AuthorizeRecordService {
	
	void save(AuthorizeRecord authorizeRecord) throws Exception;
	public List<AuthorizeRecord> findApplicationByUid(Integer uid) throws Exception;
}
