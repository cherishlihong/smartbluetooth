package com.ifox.smartbluetooth.service;

import java.util.List;

import com.ifox.smartbluetooth.domain.LogRecord;

import net.sf.json.JSONObject;

public interface LogRecordService {
	
	  List<LogRecord>  findAllLog() throws Exception;
	  List<LogRecord> findLogByUid(Integer uid) throws Exception;
	  List<LogRecord> findLogByLid(Integer lid) throws Exception;
	//  JSONObject  submitLog(LogRecord logRecord,Integer uid) throws Exception;
	  void save(LogRecord logRecord) throws  Exception;
}
