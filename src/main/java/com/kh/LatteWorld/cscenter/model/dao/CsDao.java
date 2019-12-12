package com.kh.LatteWorld.cscenter.model.dao;

import java.util.ArrayList;


import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.LatteWorld.cscenter.model.vo.Cscenter;

@Repository("CsDao")
public class CsDao {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public ArrayList<Cscenter> selectList(){ 
		 return (ArrayList)sqlSession.selectList("cscenterMapper.selectCscenter");
	 }

	public int insertCscenter(Cscenter cs) {
		System.out.println("dao cs :" + cs);
		return sqlSession.insert("cscenterMapper.insertCscenter", cs);
	}

	public int updateCsReply(Cscenter cs) {
		System.out.println("dao cs :" + cs);
		return sqlSession.update("cscenterMapper.updateCscenter", cs);
	}


}
