package com.ifox.smartbluetooth.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ifox.smartbluetooth.dao.AuthorizeRecordDao;
import com.ifox.smartbluetooth.domain.AuthorizeRecord;
import com.ifox.smartbluetooth.service.AuthorizeRecordService;

@Service("authorizeRecordSercice")
public class AuthorizeRecordSerciceImpl implements AuthorizeRecordService {

	@Autowired
	private AuthorizeRecordDao authorizeRecordDao;
	
	public void save(AuthorizeRecord authorizeRecord) throws Exception {
		authorizeRecordDao.save(authorizeRecord);
	}

	public List<AuthorizeRecord> findApplicationByUid(Integer uid) throws Exception {
		return authorizeRecordDao.findApplicationByUid(uid);
	}

}
