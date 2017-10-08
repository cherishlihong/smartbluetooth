package com.ifox.smartbluetooth.service;


import com.ifox.smartbluetooth.domain.Application;
import com.ifox.smartbluetooth.domain.LogRecord;
import com.ifox.smartbluetooth.domain.User;

import net.sf.json.JSONObject;

public interface UserControllerService {
	
	JSONObject handleLogin(User user) throws Exception;
	JSONObject handleApplicate(Application application, Integer uid) throws Exception;
	JSONObject findSuccessApplicate(Integer uid) throws Exception ;
	String findCheckingKey(Integer uid) throws Exception ;
	JSONObject findLog(Integer uid) throws Exception;
	JSONObject submitLog(LogRecord logRecord,Integer uid,Integer lid) throws Exception;
	
}
