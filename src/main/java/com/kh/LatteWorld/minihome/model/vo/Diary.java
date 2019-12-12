package com.kh.LatteWorld.minihome.model.vo;

import java.sql.Date;

public class Diary {
	private int dNo;
	private int homepyNo;
	private String dContent;
	private Date dCreateDt;
	private String dStatus;

	public Diary() {
	}

	public Diary(int dNo, int homepyNo, String dContent, Date dCreateDt, String dStatus) {
		this.dNo = dNo;
		this.homepyNo = homepyNo;
		this.dContent = dContent;
		this.dCreateDt = dCreateDt;
		this.dStatus = dStatus;
	}

	public int getdNo() {
		return dNo;
	}

	public void setdNo(int dNo) {
		this.dNo = dNo;
	}

	public int getHomepyNo() {
		return homepyNo;
	}

	public void setHomepyNo(int homepyNo) {
		this.homepyNo = homepyNo;
	}

	public String getdContent() {
		return dContent;
	}

	public void setdContent(String dContent) {
		this.dContent = dContent;
	}

	public Date getdCreateDt() {
		return dCreateDt;
	}

	public void setdCreateDt(Date dCreateDt) {
		this.dCreateDt = dCreateDt;
	}

	public String getdStatus() {
		return dStatus;
	}

	public void setdStatus(String dStatus) {
		this.dStatus = dStatus;
	}

	@Override
	public String toString() {
		return "Diary [dNo=" + dNo + ", homepyNo=" + homepyNo + ", dContent=" + dContent + ", dCreateDt=" + dCreateDt
				+ ", dStatus=" + dStatus + "]";
	}
}
