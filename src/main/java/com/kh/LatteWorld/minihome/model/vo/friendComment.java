package com.kh.LatteWorld.minihome.model.vo;

public class friendComment {
	private int commentNo;
	private int homepyNo;
	private String commentWriter;
	private String commentContent;

	public friendComment() {}

	public friendComment(int commentNo, int homepyNo, String commentWriter, String commentContent) {
		this.commentNo = commentNo;
		this.homepyNo = homepyNo;
		this.commentWriter = commentWriter;
		this.commentContent = commentContent;
	}

	public int getCommentNo() {
		return commentNo;
	}

	public void setCommentNo(int commentNo) {
		this.commentNo = commentNo;
	}

	public int getHomepyNo() {
		return homepyNo;
	}

	public void setHomepyNo(int homepyNo) {
		this.homepyNo = homepyNo;
	}

	public String getCommentWriter() {
		return commentWriter;
	}

	public void setCommentWriter(String commentWriter) {
		this.commentWriter = commentWriter;
	}

	public String getCommentContent() {
		return commentContent;
	}

	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}

	@Override
	public String toString() {
		return "friendComment [commentNo=" + commentNo + ", homepyNo=" + homepyNo + ", commentWriter=" + commentWriter
				+ ", commentContent=" + commentContent + "]";
	}
}
