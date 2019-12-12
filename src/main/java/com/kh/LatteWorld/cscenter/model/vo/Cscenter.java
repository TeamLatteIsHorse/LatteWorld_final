package com.kh.LatteWorld.cscenter.model.vo;

import java.sql.Date;

public class Cscenter {
	private int csListNum;
	private String csType;
	private String csWriter;
	private String csDetail;
	private Date csDate;
	private String csReply;
	
	public Cscenter() {}

	public Cscenter(int csListNum, String csType, String csWriter, String csDetail, Date csDate, String csReply) {
		this.csListNum = csListNum;
		this.csType = csType;
		this.csWriter = csWriter;
		this.csDetail = csDetail;
		this.csDate = csDate;
		this.csReply = csReply;
	}

	public int getCsListNum() {
		return csListNum;
	}

	public void setCsListNum(int csListNum) {
		this.csListNum = csListNum;
	}

	public String getCsType() {
		return csType;
	}

	public void setCsType(String csType) {
		this.csType = csType;
	}

	public String getCsWriter() {
		return csWriter;
	}

	public void setCsWriter(String csWriter) {
		this.csWriter = csWriter;
	}

	public String getCsDetail() {
		return csDetail;
	}

	public void setCsDetail(String csDetail) {
		this.csDetail = csDetail;
	}

	public Date getCsDate() {
		return csDate;
	}

	public void setCsDate(Date csDate) {
		this.csDate = csDate;
	}

	public String getCsReply() {
		return csReply;
	}

	public void setCsReply(String csReply) {
		this.csReply = csReply;
	}

	@Override
	public String toString() {
		return "Cscenter [csListNum=" + csListNum + ", csType=" + csType + ", csWriter=" + csWriter + ", csDetail="
				+ csDetail + ", csDate=" + csDate + ", csReply=" + csReply + "]";
	}
	
	


	
	
	
}
