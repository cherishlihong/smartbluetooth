package com.ifox.smartbluetooth.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ifox.smartbluetooth.domain.Application;
import com.ifox.smartbluetooth.domain.AuthorizeRecord;
import com.ifox.smartbluetooth.domain.Lock;
import com.ifox.smartbluetooth.domain.LogRecord;
import com.ifox.smartbluetooth.domain.User;
import com.ifox.smartbluetooth.service.ApplicationService;
import com.ifox.smartbluetooth.service.AuthorizeRecordService;
import com.ifox.smartbluetooth.service.LockService;
import com.ifox.smartbluetooth.service.LogRecordService;
import com.ifox.smartbluetooth.service.UserControllerService;
import com.ifox.smartbluetooth.service.UserService;
import com.ifox.smartbluetooth.utils.Constants;
import com.ifox.smartbluetooth.utils.ControllerUtil;
import com.ifox.smartbluetooth.utils.TypeConversion;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Service("userControllerService")
public class UserControllerServiceImpl implements UserControllerService{

	@Autowired
	private UserService userService;
	
	@Autowired
	private ApplicationService applicateServive;
	@Autowired
	private AuthorizeRecordService authorizeRecordSercice;
	@Autowired
	private LogRecordService logRecordService;
	@Autowired
	private LockService lockService;
 	@Autowired
 	private ControllerUtil controllerUtil;
 	
	public JSONObject handleLogin(User user) throws Exception {
		JSONArray jsonArray = new JSONArray();
		JSONObject jsonObject = new JSONObject();
		JSONObject jsonObject2 = new JSONObject();
		String code = "";
		User user2 = userService.findByNamePwd(user.getUserName(),user.getUserPwd()); 
		if(user2!=null) {
			code = Constants.SUCCESS_CODE;
			jsonObject.put("desc", Constants.USER_LOGIN_SUCCESS_MSG);
			jsonObject2.put("uid", user2.getUid());
		}else{
			code = Constants.ERROR_CODE;
			jsonObject.put("desc", Constants.USER_LOGIN_FAIL_MSG);
		}
		jsonObject.put("code",code);
		jsonObject.put("data", jsonObject2);
		jsonArray.add(jsonObject);
		return jsonArray.getJSONObject(0);
	}

	public JSONObject handleApplicate(Application application,Integer uid) throws Exception {
		JSONArray jsonArray = new JSONArray();
		JSONObject jsonObject = new JSONObject();
		String code = "";
		String desc = "";
		if (application!=null) {
			User user = userService.findByUid(uid);
				 if(user != null){
					 application.setUser(user);
					 application.setFlag(false);
					applicateServive.save(application);
					code = Constants.SUCCESS_CODE;
					desc = Constants.USER_APPLICATION_SUCCESS_MSG;
				 }
		}
	   else{
		    code = Constants.ERROR_CODE;
		    desc = Constants.USER_APPLICATION_FAIL_MSG;
		}
		jsonObject.put("code",code);
	 	jsonObject.put("desc",desc);
	 	jsonArray.add(jsonObject);
		return jsonArray.getJSONObject(0);
	}
	
	public JSONObject findSuccessApplicate(Integer uid){
		JSONArray jsonArray = new JSONArray();
		JSONObject jsonObjectData = new JSONObject();
		String code = "";
		String desc = "";
			try {
				List<AuthorizeRecord> authorizeRecords = authorizeRecordSercice.findApplicationByUid(uid);
				if (authorizeRecords!=null&&authorizeRecords.size()>0) {
					for(AuthorizeRecord authorizeRecord:authorizeRecords){
						JSONObject jObject =new JSONObject();
						jObject.put("lid", authorizeRecord.getLock().getLid());
						jObject.put("lockAddress", authorizeRecord.getLock().getLockAddress());
						jObject.put("endTime", authorizeRecord.getEndTime());
						jObject.put("count", authorizeRecord.getCount());
						 jsonArray.add(jObject);
					}
					jsonObjectData.put("data", jsonArray);
					code = Constants.SUCCESS_CODE;
					desc = Constants.USER_FINDNOKEY_MSG;
				} 
				 
			} catch (Exception e) {
				e.printStackTrace();
				code = Constants.ERROR_CODE;
				desc = Constants.USER_FINDKEY_FAIL_MSG;
			}
			jsonObjectData.put("code", code);
			jsonObjectData.put("desc", desc);
		return jsonObjectData;
	}
	

	public JSONObject findLog(Integer uid) throws Exception {
		JSONArray jsonArrayData = new JSONArray();
		JSONObject jsonObjectData = new JSONObject();
		String code = Constants.ERROR_CODE;
		String desc =  Constants.USER_FINDNOLOG_MSG;
		Set<Lock> locks = new HashSet<Lock>();
		
		List<LogRecord> logRecords = logRecordService.findLogByUid(uid);
		if (logRecords!=null&&logRecords.size()>0) {
			for(int i=0;i<logRecords.size();i++){
				locks.add(logRecords.get(i).getLock());
			}
			for(Lock lock:locks){
				List<LogRecord> logRecords2 = logRecordService.findLogByLid(lock.getLid());
				JSONObject jObject =new JSONObject();
				jObject.put("address", logRecords2.get(0).getLock().getLockAddress());
				JSONArray jsonArrayNote = new JSONArray();
				for(LogRecord logRecord:logRecords2){
					JSONObject jObjectNote =new JSONObject();
					jObjectNote.put("beginTime", logRecord.getOpenDoorTime());
					jObjectNote.put("endTime", logRecord.getOpenEndTime());
					jsonArrayNote.add(jObjectNote);
				}
				    jObject.put("timeDate", jsonArrayNote);
				 jsonArrayData.add(jObject);
			}
			jsonObjectData.put("data", jsonArrayData);
			code = Constants.SUCCESS_CODE;
			desc = Constants.USER_FINDLOG_SUCCESS_MSG;
		} 
		jsonObjectData.put("code", code);
		jsonObjectData.put("desc", desc);
		return jsonObjectData;
	}

	public JSONObject submitLog(LogRecord logRecord,Integer uid,Integer lid) throws Exception {
		JSONArray jsonArray = new JSONArray();
		JSONObject jsonObject = new JSONObject();
		String code = "";
		String desc = "";
		if (logRecord!=null) {
			User user = userService.findByUid(uid);
			Lock lock = lockService.findByLid(lid);
				 if(user!= null&&lock!=null){
					 logRecord.setUser(user);
					 logRecord.setLock(lock);
					 logRecordService.save(logRecord);
					code = Constants.SUCCESS_CODE;
					desc = Constants.USER_SUBMITLOG_SUCCESS_MSG;
				 }
		}
	   else{
		    code = Constants.ERROR_CODE;
		    desc = Constants.USER_SUBMITLOG_FAIL_MSG;
		}
		jsonObject.put("code",code);
	 	jsonObject.put("desc",desc);
	 	jsonArray.add(jsonObject);
	 	System.out.println("返回结果街"+jsonArray.getJSONObject(0));
		return jsonArray.getJSONObject(0);
	}
	
/*
 * unuseful
 * */
	public String findCheckingKey(Integer uid) throws Exception {
//		JSONArray jsonArray = new JSONArray();
//		JSONObject jsonObjectData = new JSONObject();
//		String code = Constants.ERROR_CODE;
//		String desc =  Constants.USER_FINDNOCHECK_KEY_MSG;
//		List<Application> applications = applicateServive.findCheckingApplictionByFlag(uid);
//		if (applications!=null&&applications.size()>0) {
//			for(Application application:applications){
//				JSONObject jObject =new JSONObject();
//				jObject.put("address", application.getA_address());
//				jObject.put("beginTime", application.getA_beginTime());
//				jObject.put("endTime", application.getA_beginTime());
//				jObject.put("count", application.getA_count());
//				 jsonArray.add(jObject);
//			}
//			jsonObjectData.put("data", jsonArray);
//			code = Constants.SUCCESS_CODE;
//			desc = Constants.USER_FINDCHECK_KEY_SUCCESS_MSG;
//		} 
//		jsonObjectData.put("code", code);
//		jsonObjectData.put("desc", desc);
		return null;
	}

}
