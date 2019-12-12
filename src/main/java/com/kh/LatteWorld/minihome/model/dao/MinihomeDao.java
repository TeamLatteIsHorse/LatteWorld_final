package com.kh.LatteWorld.minihome.model.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.LatteWorld.common.PageInfo;
import com.kh.LatteWorld.minihome.model.vo.MiniHomeFolder;
import com.kh.LatteWorld.minihome.model.vo.MiniHomePost;
import com.kh.LatteWorld.minihome.model.vo.MiniHomeProfile;
import com.kh.LatteWorld.minihome.model.vo.Minihomepy;

@Repository("miniDao")
public class MinihomeDao {
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	public Minihomepy selectMiniHome(String userId) {
		return sqlSession.selectOne("miniHomeMapper.selectMiniHomeUserId", userId);
	}
	
	public Minihomepy selectMiniHome(Integer homepyNo) {
		return sqlSession.selectOne("miniHomeMapper.selectMiniHomeNo", homepyNo);
	}
	
	public MiniHomeProfile selectMiniHomeProfile(String userId) {
		return (MiniHomeProfile)sqlSession.selectOne("miniHomeMapper.selectMiniHomeProfile", userId);
	}

	public MiniHomeProfile selectProfileImg(String homepyNo) {
		return (MiniHomeProfile)sqlSession.selectOne("miniHomeMapper.selectProfileImg", homepyNo);
	}

	public int updateMiniHomeProfile(MiniHomeProfile mp) {
		return sqlSession.update("miniHomeMapper.updateMiniHomeProfile", mp);
	}

	public int getAllPostListCount(int homepyNo, String postType) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("homepyNo", homepyNo);
		map.put("postType", postType);
		
		return sqlSession.selectOne("miniHomeMapper.AllPostListCount", map);
	}

	public ArrayList<MiniHomePost> selectAllPostList(PageInfo pi, int homepyNo, String postType) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("homepyNo", homepyNo);
		map.put("postType", postType);
		int offset = (pi.getCurrentPage() - 1) * pi.getBoardLimit();
		RowBounds rowBounds = new RowBounds(offset, pi.getBoardLimit());
		
		return (ArrayList)sqlSession.selectList("miniHomeMapper.selectAllPostList", map, rowBounds);
	}
	
	public ArrayList<MiniHomeFolder> selectFolderList(Integer homepyNo, String postType) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("homepyNo", homepyNo);
		map.put("postType", postType);
		return (ArrayList)sqlSession.selectList("miniHomeMapper.selectFolderList", map);
	}

	public int postDetailCount(int bNo) {
		return sqlSession.update("miniHomeMapper.postDetailCount", bNo);
	}

	public MiniHomePost selectOnePost(int bNo) {
		return sqlSession.selectOne("miniHomeMapper.selectOnePost", bNo);
	}

	public int selectPostListCount(int homepyNo, int folderNo, String postType) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("homepyNo", homepyNo);
		map.put("folderNo", folderNo);
		map.put("postType", postType);
		
		return sqlSession.selectOne("miniHomeMapper.postListCount", map);
	}

	public ArrayList<MiniHomePost> selectPostList(PageInfo pi, int homepyNo, int folderNo, String postType) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("homepyNo", homepyNo);
		map.put("folderNo", folderNo);
		map.put("postType", postType);
		
		int offset = (pi.getCurrentPage() - 1) * pi.getBoardLimit();
		RowBounds rowBounds = new RowBounds(offset, pi.getBoardLimit());
		
		return (ArrayList)sqlSession.selectList("miniHomeMapper.selectPostList", map, rowBounds);
	}

	public int addFolder(MiniHomeFolder folder) {
		return sqlSession.insert("miniHomeMapper.addFolder", folder);
	}

	public int insertPost(MiniHomePost post) {
		return sqlSession.insert("miniHomeMapper.insertPost", post);
	}
}


