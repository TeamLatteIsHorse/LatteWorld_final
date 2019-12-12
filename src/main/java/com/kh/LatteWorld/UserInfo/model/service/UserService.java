package com.kh.LatteWorld.UserInfo.model.service;

import java.util.ArrayList;

import com.kh.LatteWorld.UserInfo.model.vo.UserInfo;

public interface UserService {

	UserInfo loginUser(UserInfo u);

	int insertMember(UserInfo u);
	
	// 제가 미니홈피 부분에 쓸려고 따로 추가한 것입니다.
	UserInfo selectUser(String userId);
	
	int insertMiniHome(UserInfo u);
	
	int insertMiniHomeProfile();
	
	int insertFolderList1();
	
	int insertFolderList2();
	
	// 여기까지가 미니홈피 관련 메소드
	
	UserInfo selectUser(UserInfo u);

	int updateUser(UserInfo u);

	int checkIdDup(String id);
	
	// (임시) 일촌신청할 목록 가져오는 것
	ArrayList<UserInfo> selectrecommendFriend();
}
