package com.ifox.smartbluetooth.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ifox.smartbluetooth.dao.BaseDao;
import com.ifox.smartbluetooth.dao.LockDao;
import com.ifox.smartbluetooth.domain.Lock;
import com.ifox.smartbluetooth.utils.ValueUtil;

@Repository("lockDao")
public class LockDaoImpl implements LockDao {

	@Autowired
	private BaseDao<Lock> baseDao;
	public void save(Lock lock) throws Exception {
		baseDao.save(lock);
	}

	public Lock findByLid(Integer lid) throws Exception {
		String hql ="from Lock where lid=?";
		Object[] params={lid};
		List<Lock> locks = baseDao.find(hql,params);
		if (ValueUtil.isNotNullList(locks)) {
			return locks.get(0);
		}
		return null;
	}

}
