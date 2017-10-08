package com.ifox.smartbluetooth.service;

import com.ifox.smartbluetooth.domain.Lock;

public interface LockService {
	
	public void save(Lock lock) throws Exception;
	public Lock findByLid(Integer lid) throws Exception ;
}
