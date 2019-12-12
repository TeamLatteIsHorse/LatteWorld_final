package com.kh.LatteWorld.minihome.model.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.LatteWorld.common.PageInfo;
import com.kh.LatteWorld.minihome.model.dao.MinihomeDao;
import com.kh.LatteWorld.minihome.model.vo.MiniHomeFolder;
import com.kh.LatteWorld.minihome.model.vo.MiniHomePost;
import com.kh.LatteWorld.minihome.model.vo.MiniHomeProfile;
import com.kh.LatteWorld.minihome.model.vo.Minihomepy;

@Service("miniService")
public class MinihomeServiceImpl implements MinihomeService{

	@Autowired
	MinihomeDao miniDao;

	@Override
	public Minihomepy selectMinihome(String userId) {
		return miniDao.selectMiniHome(userId);
	}
	
	@Override
	public Minihomepy selectMinihome(int homepyNo) {
		return miniDao.selectMiniHome(homepyNo);
	}
	
	@Override
	public MiniHomeProfile selectMiniHomeProfile(String userId) {
		return miniDao.selectMiniHomeProfile(userId);
	}

	@Override
	public MiniHomeProfile selectProfileImg(String homepyNo) {
		return miniDao.selectProfileImg(homepyNo);
	}

	@Override
	public int updateMiniHomeProfile(MiniHomeProfile mp) {
		return miniDao.updateMiniHomeProfile(mp);
	}

	@Override
	public int getAllPostListCount(int homepyNo, String postType) {
		return miniDao.getAllPostListCount(homepyNo, postType);
	}

	@Override
	public ArrayList<MiniHomePost> selectAllPostList(PageInfo pi, int homepyNo, String postType) {
		return miniDao.selectAllPostList(pi, homepyNo, postType);
	}

	@Override
	public ArrayList<MiniHomeFolder> selectFolderList(int homepyNo, String postType) {
		return miniDao.selectFolderList(homepyNo, postType);
	}
	
	@Override
	public int postDetailCount(int postNo) {
		return miniDao.postDetailCount(postNo);
	}

	@Override
	public MiniHomePost selectOnePost(int postNo) {
		return miniDao.selectOnePost(postNo);
	}

	@Override
	public int getPostListCount(int homepyNo, int folderNo, String postType) {
		return miniDao.selectPostListCount(homepyNo, folderNo, postType);
	}

	@Override
	public ArrayList<MiniHomePost> selectPostList(PageInfo pi, int homepyNo, int folderNo, String postType) {
		return miniDao.selectPostList(pi, homepyNo, folderNo, postType);
	}

	@Override
	public int addFolder(MiniHomeFolder folder) {
		return miniDao.addFolder(folder);
	}

	@Override
	public ArrayList<MiniHomeFolder> selectSetBoardList(int homepyNo, String postType) {
		return miniDao.selectFolderList(homepyNo, postType);
	}

	@Override
	public int insertPost(MiniHomePost post) {
		return miniDao.insertPost(post);
	}
}
