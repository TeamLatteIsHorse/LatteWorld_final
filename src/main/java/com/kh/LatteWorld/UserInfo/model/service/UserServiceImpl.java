package com.kh.LatteWorld.UserInfo.model.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.LatteWorld.UserInfo.model.dao.UserDao;
import com.kh.LatteWorld.UserInfo.model.vo.UserInfo;

@Service("uService")
public class UserServiceImpl implements UserService {
	@Autowired
	UserDao uDao;

	@Override
	public UserInfo loginUser(UserInfo u) {
		return uDao.selectUser(u);
	}

	@Override
	public int insertMember(UserInfo u) {
		return uDao.insertUser(u);
	}
	
	// 미니홈피
	
	@Override
	public UserInfo selectUser(String userId) {
		return uDao.selectUser(userId);
	}
	
	@Override
	public int insertMiniHome(UserInfo u) {
		return uDao.insertMiniHome(u);
	}
	
	@Override
	public int insertMiniHomeProfile() {
		return uDao.insertMiniHomeProfile();
	}
	
	@Override
	public int insertFolderList1() {
		return uDao.insertFolderList1();
	}

	@Override
	public int insertFolderList2() {
		return uDao.insertFolderList2();
	}
	
	// 미니홈피
	
	@Override
	public UserInfo selectUser(UserInfo u) {
		
		return uDao.selectUser(u);
	}

	@Override
	public int updateUser(UserInfo u) {
		return uDao.updateUser(u);
	}

	@Override
	public int checkIdDup(String userId) {
		return uDao.checkIdDup(userId);
	}
	
	
	// (임시)
	@Override
	public ArrayList<UserInfo> selectrecommendFriend() {
		return uDao.selectrecommendFriend();
	}
}
