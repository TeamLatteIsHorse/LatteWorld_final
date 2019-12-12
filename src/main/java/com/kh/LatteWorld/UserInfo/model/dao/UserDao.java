package com.kh.LatteWorld.UserInfo.model.dao;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.LatteWorld.UserInfo.model.vo.UserInfo;

@Repository("uDao")
public class UserDao {

	@Autowired
	private SqlSessionTemplate sqlSession;

	public UserInfo selectUser(UserInfo u) {
		return (UserInfo)sqlSession.selectOne("userinfoMapper.selectUser", u);
	}

	public int insertUser(UserInfo u) {

		return sqlSession.insert("userinfoMapper.insertUser", u);
	}
	
	// 미니홈피에서 쓰는 것
	public UserInfo selectUser(String userId) {
		return sqlSession.selectOne("userinfoMapper.selectUserInfo", userId);
	}
	
	// 회원가입 할 때 미니홈피 기본정보
	public int insertMiniHome(UserInfo u) {
		return sqlSession.insert("userinfoMapper.insertMiniHome", u);
	}
	
	// 미니홈피 프로필
	public int insertMiniHomeProfile() {
		return sqlSession.insert("userinfoMapper.insertMiniHomeProfile");
	}
	
	// 미니홈피 일반게시판 기본값
	public int insertFolderList1() {
		return sqlSession.insert("userinfoMapper.insertFolderList1");
	}
	// 미니홈피 사진게시판 기본값
	public int insertFolderList2() {
		return sqlSession.insert("userinfoMapper.insertFolderList2");
	}

	public int updateUser(UserInfo u) {
		
		return sqlSession.update("userinfoMapper.updateUser", u);
	}

	public int checkIdDup(String userId) {
		
		return sqlSession.selectOne("userinfoMapper.checkIdDup", userId);
	}

	public ArrayList<UserInfo> selectrecommendFriend() {
		return (ArrayList)sqlSession.selectList("userinfoMapper.recommendFriend");
	}
	
}
