package com.ifox.smartbluetooth.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ifox.smartbluetooth.dao.LockDao;
import com.ifox.smartbluetooth.domain.Lock;
import com.ifox.smartbluetooth.service.LockService;

@Service("lockService")
public class LockServiceImpl implements LockService {

	@Autowired
	private LockDao lockDao;
	public void save(Lock lock) throws Exception {
		lockDao.save(lock);
	}

	public Lock findByLid(Integer lid) throws Exception {
		return lockDao.findByLid(lid);
	}

}
