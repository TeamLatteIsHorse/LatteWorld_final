package com.kh.LatteWorld.minihome.model.vo;

import java.sql.Date;

public class GuestBook {
	private int gbNo;
	private int homepyNo;
	private String gbWriter;
	private String gbContent;
	private Date gbCerateDt;
	private String gbStatus;

	public GuestBook() {}

	public GuestBook(int gbNo, int homepyNo, String gbWriter, String gbContent, Date gbCerateDt, String gbStatus) {
		this.gbNo = gbNo;
		this.homepyNo = homepyNo;
		this.gbWriter = gbWriter;
		this.gbContent = gbContent;
		this.gbCerateDt = gbCerateDt;
		this.gbStatus = gbStatus;
	}

	public int getGbNo() {
		return gbNo;
	}

	public void setGbNo(int gbNo) {
		this.gbNo = gbNo;
	}

	public int getHomepyNo() {
		return homepyNo;
	}

	public void setHomepyNo(int homepyNo) {
		this.homepyNo = homepyNo;
	}

	public String getGbWriter() {
		return gbWriter;
	}

	public void setGbWriter(String gbWriter) {
		this.gbWriter = gbWriter;
	}

	public String getGbContent() {
		return gbContent;
	}

	public void setGbContent(String gbContent) {
		this.gbContent = gbContent;
	}

	public Date getGbCerateDt() {
		return gbCerateDt;
	}

	public void setGbCerateDt(Date gbCerateDt) {
		this.gbCerateDt = gbCerateDt;
	}

	public String getGbStatus() {
		return gbStatus;
	}

	public void setGbStatus(String gbStatus) {
		this.gbStatus = gbStatus;
	}

	@Override
	public String toString() {
		return "GuestBook [gbNo=" + gbNo + ", homepyNo=" + homepyNo + ", gbWriter=" + gbWriter + ", gbContent="
				+ gbContent + ", gbCerateDt=" + gbCerateDt + ", gbStatus=" + gbStatus + "]";
	}
}
