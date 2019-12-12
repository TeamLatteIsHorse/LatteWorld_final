package com.kh.LatteWorld.cscenter.model.service;

import java.util.ArrayList;


import com.kh.LatteWorld.cscenter.model.vo.Cscenter;

public interface CsService {
	
	/*
	 * 1. 문의사항 전체 조회 
	 */
	public ArrayList<Cscenter> selectList();
	
	/*
	 * 2 문의사항 등록 
	 */
	public int insertCscenter(Cscenter cs);
	
	public int updateCsReply(Cscenter cs);
	
}
