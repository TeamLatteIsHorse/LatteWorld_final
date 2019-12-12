package com.kh.LatteWorld.minihome.model.service;

import java.util.ArrayList;

import com.kh.LatteWorld.common.PageInfo;
import com.kh.LatteWorld.minihome.model.vo.MiniHomeFolder;
import com.kh.LatteWorld.minihome.model.vo.MiniHomePost;
import com.kh.LatteWorld.minihome.model.vo.MiniHomeProfile;
import com.kh.LatteWorld.minihome.model.vo.Minihomepy;

public interface MinihomeService {

	Minihomepy selectMinihome(String userId);
	
	Minihomepy selectMinihome(int homepyNo);
	
	MiniHomeProfile selectMiniHomeProfile(String userId);
	
	MiniHomeProfile selectProfileImg(String homepyNo);
	
	int updateMiniHomeProfile(MiniHomeProfile mp);

	int getAllPostListCount(int homepyNo, String postType);

	ArrayList<MiniHomePost> selectAllPostList(PageInfo pi, int homepyNo, String postType);
	
	ArrayList<MiniHomeFolder> selectFolderList(int homepyNo, String postType);

	int postDetailCount(int postNo);

	MiniHomePost selectOnePost(int postNo);

	int getPostListCount(int homepyNo, int folderNo, String postType);

	ArrayList<MiniHomePost> selectPostList(PageInfo pi, int homepyNo, int folderNo, String postType);

	int addFolder(MiniHomeFolder folder);

	ArrayList<MiniHomeFolder> selectSetBoardList(int homepyNo, String postType);

	int insertPost(MiniHomePost post);
}
