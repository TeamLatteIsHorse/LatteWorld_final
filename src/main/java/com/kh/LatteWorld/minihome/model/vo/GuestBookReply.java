package com.kh.LatteWorld.minihome.model.vo;

import java.sql.Date;

public class GuestBookReply {
	private int gbrNo;
	private int gbNo;
	private String gbrWriter;
	private String grContent;
	private Date grCreateDT;

	public GuestBookReply() {
	}

	public GuestBookReply(int gbrNo, int gbNo, String gbrWriter, String grContent, Date grCreateDT) {
		this.gbrNo = gbrNo;
		this.gbNo = gbNo;
		this.gbrWriter = gbrWriter;
		this.grContent = grContent;
		this.grCreateDT = grCreateDT;
	}

	public int getGbrNo() {
		return gbrNo;
	}

	public void setGbrNo(int gbrNo) {
		this.gbrNo = gbrNo;
	}

	public int getGbNo() {
		return gbNo;
	}

	public void setGbNo(int gbNo) {
		this.gbNo = gbNo;
	}

	public String getGbrWriter() {
		return gbrWriter;
	}

	public void setGbrWriter(String gbrWriter) {
		this.gbrWriter = gbrWriter;
	}

	public String getGrContent() {
		return grContent;
	}

	public void setGrContent(String grContent) {
		this.grContent = grContent;
	}

	public Date getGrCreateDT() {
		return grCreateDT;
	}

	public void setGrCreateDT(Date grCreateDT) {
		this.grCreateDT = grCreateDT;
	}

	@Override
	public String toString() {
		return "GuestBookReply [gbrNo=" + gbrNo + ", gbNo=" + gbNo + ", gbrWriter=" + gbrWriter + ", grContent="
				+ grContent + ", grCreateDT=" + grCreateDT + "]";
	}
}
