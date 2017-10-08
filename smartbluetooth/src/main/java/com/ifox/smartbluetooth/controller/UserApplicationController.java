package com.ifox.smartbluetooth.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ifox.smartbluetooth.domain.Application;
import com.ifox.smartbluetooth.service.ApplicationService;
import com.ifox.smartbluetooth.service.AuthorizeRecordService;
import com.ifox.smartbluetooth.service.UserControllerService;
import com.ifox.smartbluetooth.utils.ControllerUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
@RequestMapping("/user")
public class UserApplicationController {
	
	@Autowired
	private UserControllerService userControllerService;
	@Autowired
	private AuthorizeRecordService AuthorizeRecordSercice;
	@Autowired
	private ControllerUtil controllerUtil;

	@Autowired
	private ApplicationService applicateServive;
	
	@RequestMapping("/applicate")
	public void userApplicate(Application application,Integer uid,HttpServletResponse response) throws Exception{
	 
		JSONObject jsonObject = userControllerService.handleApplicate(application,uid);
		controllerUtil.responseOut(jsonObject, response);
	}
	
	@RequestMapping("/findkey")
	public void findKey(Integer uid,HttpServletResponse response) throws Exception{
		JSONObject jsonObject  = userControllerService.findSuccessApplicate(uid);
		controllerUtil.responseOut(jsonObject, response);
	}
	
	@RequestMapping("/findKey/checking")
	public String CheckingKey(Integer uid,Model model) throws Exception{
		List<Application> applications = applicateServive.findCheckingApplictionByFlag(uid);
		
		model.addAttribute("applications", applications);
		System.out.println("============="+applications);
		return "user/checkingKey"; 

//		String  =userControllerService.findCheckingKey(uid);
//		controllerUtil.responseOut(jsonObject, response);
	}
	
}
