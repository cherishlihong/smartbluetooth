package com.ifox.smartbluetooth.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ifox.smartbluetooth.dao.UserDao;
import com.ifox.smartbluetooth.domain.User;
import com.ifox.smartbluetooth.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDao userDao;
	/*
	 * todo
	 * */
//	public String save(User user) throws Exception {
//		return null;
//	}

	public User findByNamePwd(String userName,String userPwd) throws Exception {
		return userDao.findByNamePwd(userName,userPwd);
	}

	public User findByUserName(String userName) throws Exception {
		
		return userDao.findByUserName(userName);
	}

	public User findByUid(Integer uid) throws Exception {
		return userDao.findByUid(uid);
	}

}
