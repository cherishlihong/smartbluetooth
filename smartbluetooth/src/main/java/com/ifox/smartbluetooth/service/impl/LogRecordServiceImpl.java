package com.ifox.smartbluetooth.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ifox.smartbluetooth.dao.LogRecordDao;
import com.ifox.smartbluetooth.domain.Application;
import com.ifox.smartbluetooth.domain.LogRecord;
import com.ifox.smartbluetooth.service.LogRecordService;

import net.sf.json.JSONObject;

@Service("logRecordService")
public class LogRecordServiceImpl implements LogRecordService {
@Autowired
private LogRecordDao logRecordDao;
	public List<LogRecord> findAllLog() throws Exception {
		return logRecordDao.findAllLog();
	}

	public List<LogRecord> findLogByUid(Integer uid) throws Exception {
		
		return logRecordDao.findLogByUid(uid);
	}

	public List<LogRecord> findLogByLid(Integer lid) throws Exception {
		
		return logRecordDao.findLogByLid(lid);
	}

	public void save(LogRecord logRecord) throws Exception {
		logRecordDao.save(logRecord);
	}

//	public JSONObject submitLog(LogRecord logRecord, Integer uid) throws Exception {
//		return logRecordDao.;
//	}

	
}
