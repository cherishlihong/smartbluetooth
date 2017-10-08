package com.ifox.smartbluetooth.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ifox.smartbluetooth.domain.LogRecord;
import com.ifox.smartbluetooth.service.UserControllerService;
import com.ifox.smartbluetooth.utils.ControllerUtil;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("/user")
public class UserLogController {
	@Autowired
	private ControllerUtil controllerUtil;
	
	@Autowired
	private UserControllerService userControllerService;
	
	@RequestMapping("/findlog")
	public void findAllLog(Integer uid,HttpServletResponse response) throws Exception{
		JSONObject jsonObject = userControllerService.findLog(uid);
		controllerUtil.responseOut(jsonObject, response);
	}
	
	@RequestMapping("/submitLog")
	public void findSubmitLog(LogRecord logRecord,Integer uid,Integer lid,HttpServletResponse response) throws Exception{
		JSONObject jsonObject = userControllerService.submitLog(logRecord,uid,lid);
		
		controllerUtil.responseOut(jsonObject, response);
	}
}
