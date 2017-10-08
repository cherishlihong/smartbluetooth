package com.ifox.smartbluetooth.dao;

import com.ifox.smartbluetooth.domain.User;

public interface UserDao {
	
	public User findByNamePwd(String userName,String userPwd) throws Exception; //验证用户登录信息

	public User findByUserName(String userName) throws Exception;
	public User findByUid(Integer uid) throws Exception;

}
