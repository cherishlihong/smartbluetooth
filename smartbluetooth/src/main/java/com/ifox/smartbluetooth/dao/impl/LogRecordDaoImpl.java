package com.ifox.smartbluetooth.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ifox.smartbluetooth.dao.BaseDao;
import com.ifox.smartbluetooth.dao.LogRecordDao;
import com.ifox.smartbluetooth.domain.LogRecord;
import com.ifox.smartbluetooth.utils.DaoUtil;
import com.ifox.smartbluetooth.utils.ValueUtil;

@Repository("logRecordDao")
public class LogRecordDaoImpl implements LogRecordDao {

	@Autowired
	private BaseDao<LogRecord> baseDao;
	
	@Autowired
	private DaoUtil daoUtil;
	
	public List<LogRecord> findAllLog() {
		String hql = "from LogRecord order by logid";
		List<LogRecord> logRecords = daoUtil.getAll(hql);
		if (ValueUtil.isNotNullList(logRecords)) {
			
			return logRecords;
		}
		return null;
	}

	public List<LogRecord> findLogByUid(Integer uid) throws Exception {
		String hql = "from LogRecord log where log.user.uid=?"; 
		Object[] params = {uid};
		List<LogRecord> logRecords = daoUtil.getListByHql(hql, params);
		
		if (ValueUtil.isNotNullList(logRecords)) {
			
			return logRecords;
		}
		return null;
	}

	public List<LogRecord> findLogByLid(Integer lid) throws Exception {
		String hql = "from LogRecord log where log.lock.lid=?"; 
		Object[] params = {lid};
		List<LogRecord> logRecords = daoUtil.getListByHql(hql, params);
		
		if (ValueUtil.isNotNullList(logRecords)) {
			
			return logRecords;
		}
		return null;
	}

	public void save(LogRecord logRecord) throws Exception {
		baseDao.save(logRecord);
	}

}
