package com.ifox.smartbluetooth.dao;

import java.util.List;

import com.ifox.smartbluetooth.domain.AuthorizeRecord;

public interface AuthorizeRecordDao {
	
	void save(AuthorizeRecord authorizeRecord) throws Exception;
	public List<AuthorizeRecord> findApplicationByUid(Integer uid) throws Exception;
}
