package com.ifox.smartbluetooth.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ifox.smartbluetooth.dao.BaseDao;
import com.ifox.smartbluetooth.dao.UserDao;
import com.ifox.smartbluetooth.domain.User;
import com.ifox.smartbluetooth.utils.ValueUtil;

@Repository("userDao")
public class UserDaoImpl implements UserDao{

	@Autowired
	private BaseDao<User> baseDao;
	
	public User findByNamePwd(String userName, String userPwd) throws Exception {
		String hql="from User where userName=? and userPwd=?";
		Object[] paramObjs = {userName,userPwd};
		List<User> userList = baseDao.find(hql, paramObjs);
		if (ValueUtil.isNotNullList(userList)) {
			return userList.get(0);
		}else {
			return null;
		}
	}
 
	public User findByUserName(String userName) throws Exception {
		String hql = "from User where userName=?";
		Object[] paramObjs = {userName};
		List<User> userList = baseDao.find(hql, paramObjs);
		if (ValueUtil.isNotNullList(userList)) {
			return userList.get(0);
		}else {
			return null;
		}
	}
	
	public User findByUid(Integer uid) throws Exception {
		String hql = "from User where uid=?";
		Object[] paramObjs = {uid};
		List<User> userList = baseDao.find(hql, paramObjs);
		if (ValueUtil.isNotNullList(userList)) {
			return userList.get(0);
		}else {
			return null;
		}
	}
//	public void save(User user) throws Exception{
//		baseDao.save(user);
//	}
//	
	public boolean isExistByNamePwd(String userName, String userPwd) throws Exception {
		User user = findByNamePwd(userName, userPwd);
		if (user==null) {
			return false;
		}
		return true;
	}

	
}
