package com.ifox.smartbluetooth.dao;

import java.util.List;

import com.ifox.smartbluetooth.domain.LogRecord;

public interface LogRecordDao {
	
	List<LogRecord>  findAllLog() throws Exception;
	
	List<LogRecord> findLogByUid(Integer uid) throws Exception;
	List<LogRecord> findLogByLid(Integer lid) throws Exception;
	void save(LogRecord logRecord) throws Exception;
}
