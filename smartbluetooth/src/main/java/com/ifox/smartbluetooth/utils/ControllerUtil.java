package com.ifox.smartbluetooth.utils;

import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Repository;

import com.ifox.smartbluetooth.domain.User;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.util.CycleDetectionStrategy;

@Repository
public class ControllerUtil {
	public void responseOut(Object object,HttpServletResponse response) throws IOException {
		String format = null;
		if (object.getClass().equals(User.class)) {
			format="yyyy-MM-dd";
		}else{
			format = "yyyy-MM-dd hh:mm:ss";
		}
		//防止There is a cycle in the hierarchy!错误
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.setExcludes(new String[]{"handler","hibernateLazyInitializer"});
		jsonConfig.setCycleDetectionStrategy(CycleDetectionStrategy.LENIENT);
		jsonConfig.registerJsonValueProcessor(Date.class, new DateJsonValueProcessor(format));   
		response.setContentType("text/html; charset=UTF-8");
		response.getWriter().write(JSONObject.fromObject(object, jsonConfig).toString());
	}
	
	
	
	
}
