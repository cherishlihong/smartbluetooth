package com.ifox.smartbluetooth.service;

import com.ifox.smartbluetooth.domain.User;

public interface UserService {
	
	//public String save(User user) throws Exception ;
	
	public User findByNamePwd(String userName,String userPwd) throws Exception;

	public User findByUserName(String userName) throws Exception;
	public User findByUid(Integer uid) throws Exception;	
}