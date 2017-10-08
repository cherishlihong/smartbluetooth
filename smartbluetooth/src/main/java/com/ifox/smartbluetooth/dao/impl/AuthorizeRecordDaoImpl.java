package com.ifox.smartbluetooth.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ifox.smartbluetooth.dao.AuthorizeRecordDao;
import com.ifox.smartbluetooth.dao.BaseDao;
import com.ifox.smartbluetooth.domain.AuthorizeRecord;
import com.ifox.smartbluetooth.domain.User;
import com.ifox.smartbluetooth.utils.ValueUtil;

@Repository("authorizeRecordDao")
public class AuthorizeRecordDaoImpl implements AuthorizeRecordDao {
	@Autowired
	private BaseDao<AuthorizeRecord> baseDao;
	
	public void save(AuthorizeRecord authorizeRecord) throws Exception {
		 
		baseDao.save(authorizeRecord);
	}

	public List<AuthorizeRecord> findApplicationByUid(Integer uid) throws Exception {
		String hql = "from AuthorizeRecord authori where authori.user.uid=?";
		Object[] paramObjs = {uid};
		List<AuthorizeRecord> authorizeRecords = baseDao.find(hql,paramObjs);
		if (ValueUtil.isNotNullList(authorizeRecords)) {
			return authorizeRecords;
		}else {
			return null;
		}
	}

}
