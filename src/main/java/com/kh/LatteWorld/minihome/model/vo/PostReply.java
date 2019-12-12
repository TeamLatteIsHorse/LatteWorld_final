package com.kh.LatteWorld.minihome.model.vo;

import java.sql.Date;

public class PostReply {
	private int prNo;
	private int postNo;
	private String prWriter;
	private String prContent;
	private Date prCreateDT;

	public PostReply() {}

	public PostReply(int prNo, int postNo, String prWriter, String prContent, Date prCreateDT) {
		this.prNo = prNo;
		this.postNo = postNo;
		this.prWriter = prWriter;
		this.prContent = prContent;
		this.prCreateDT = prCreateDT;
	}

	public int getPrNo() {
		return prNo;
	}

	public void setPrNo(int prNo) {
		this.prNo = prNo;
	}

	public int getPostNo() {
		return postNo;
	}

	public void setPostNo(int postNo) {
		this.postNo = postNo;
	}

	public String getPrWriter() {
		return prWriter;
	}

	public void setPrWriter(String prWriter) {
		this.prWriter = prWriter;
	}

	public String getPrContent() {
		return prContent;
	}

	public void setPrContent(String prContent) {
		this.prContent = prContent;
	}

	public Date getPrCreateDT() {
		return prCreateDT;
	}

	public void setPrCreateDT(Date prCreateDT) {
		this.prCreateDT = prCreateDT;
	}

	@Override
	public String toString() {
		return "PostReply [prNo=" + prNo + ", postNo=" + postNo + ", prWriter=" + prWriter + ", prContent=" + prContent
				+ ", prCreateDT=" + prCreateDT + "]";
	}
}
