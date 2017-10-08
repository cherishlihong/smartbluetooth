package com.ifox.smartbluetooth.utils;

import net.sf.json.JSONObject;

public class TypeConversion {
	
	public static JSONObject string2JSONObject(String param) {
		String key = "code";
		return string2JSONObject(key,param);
	}

	public static JSONObject string2JSONObject(String key, String param){
		JSONObject jsonObject = new JSONObject();
		jsonObject.put(key,param);
		return jsonObject;		
	}
}
