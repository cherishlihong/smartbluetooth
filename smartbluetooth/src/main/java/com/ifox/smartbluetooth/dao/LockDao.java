package com.ifox.smartbluetooth.dao;

import com.ifox.smartbluetooth.domain.Lock;

public interface LockDao {
	void save(Lock lock) throws Exception;
	public Lock findByLid(Integer lid) throws Exception;

}
