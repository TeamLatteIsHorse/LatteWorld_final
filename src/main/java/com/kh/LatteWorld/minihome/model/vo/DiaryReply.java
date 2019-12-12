package com.kh.LatteWorld.minihome.model.vo;

import java.sql.Date;

public class DiaryReply {
	private int drNo;
	private int dNo;
	private String drWriter;
	private String drContent;
	private Date drCreateDt;

	public DiaryReply() {}

	public DiaryReply(int drNo, int dNo, String drWriter, String drContent, Date drCreateDt) {
		this.drNo = drNo;
		this.dNo = dNo;
		this.drWriter = drWriter;
		this.drContent = drContent;
		this.drCreateDt = drCreateDt;
	}

	public int getDrNo() {
		return drNo;
	}

	public void setDrNo(int drNo) {
		this.drNo = drNo;
	}

	public int getdNo() {
		return dNo;
	}

	public void setdNo(int dNo) {
		this.dNo = dNo;
	}

	public String getDrWriter() {
		return drWriter;
	}

	public void setDrWriter(String drWriter) {
		this.drWriter = drWriter;
	}

	public String getDrContent() {
		return drContent;
	}

	public void setDrContent(String drContent) {
		this.drContent = drContent;
	}

	public Date getDrCreateDt() {
		return drCreateDt;
	}

	public void setDrCreateDt(Date drCreateDt) {
		this.drCreateDt = drCreateDt;
	}

	@Override
	public String toString() {
		return "DiaryReply [drNo=" + drNo + ", dNo=" + dNo + ", drWriter=" + drWriter + ", drContent=" + drContent
				+ ", drCreateDt=" + drCreateDt + "]";
	}

}
