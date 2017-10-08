package com.ifox.smartbluetooth.controller;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ifox.smartbluetooth.domain.User;
import com.ifox.smartbluetooth.service.UserControllerService;
import com.ifox.smartbluetooth.service.UserService;
import com.ifox.smartbluetooth.utils.Constants;
import com.ifox.smartbluetooth.utils.ControllerUtil;
import com.ifox.smartbluetooth.utils.TypeConversion;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
@RequestMapping("/user")
public class UserController {
 
 	@Autowired
 	private UserService userService;

	@Autowired
	private ControllerUtil controllerUtil;
	
	@Autowired
	private UserControllerService userControllerService;
	
	@RequestMapping(value="/login")
	public void login(User user,HttpServletResponse response) throws IOException{
//		HttpServletRequest request;
//		String contTyope = request.getContentType()可以验证接受的类型。contTyope.equals("json")
		System.out.println("fdhijhlu接受值"+user.getUserName());
		JSONObject jsonObject;
		try {
			jsonObject = userControllerService.handleLogin(user);
			controllerUtil.responseOut(jsonObject,response);
			System.out.println("返回值是===="+jsonObject);
		} catch (Exception e) {
			controllerUtil.responseOut(TypeConversion.string2JSONObject(Constants.SERVICE_ERROR_CODE),response);
			e.printStackTrace();
		}
	}
}
