package com.kh.LatteWorld.cscenter.model.service;

import java.util.ArrayList;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.LatteWorld.cscenter.model.dao.CsDao;
import com.kh.LatteWorld.cscenter.model.vo.Cscenter;

@Service("CsService")
public class CsServiceImpl implements CsService{

	@Autowired
	private CsDao CsDao;
	
	@Override
	public ArrayList<Cscenter> selectList() {	
		return CsDao.selectList();
	}

	@Override
	public int insertCscenter(Cscenter cs) {
		System.out.println("service cs :"+cs );
		return CsDao.insertCscenter(cs);	
	}
	
	@Override
	public int updateCsReply(Cscenter cs){
		System.out.println("service cs :");
		return CsDao.updateCsReply(cs);
		
		
	}

}
