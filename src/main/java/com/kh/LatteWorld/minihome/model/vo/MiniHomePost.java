package com.kh.LatteWorld.minihome.model.vo;

import java.sql.Date;

public class MiniHomePost {
	private int postNo;
	private int homepyNo;
	private String postWriter;
	private int folderNo;
	private String postType;
	private String postTitle;
	private String postContent;
	private Date postCreateDT;
	private int recommendCount;
	private String postStatus;
	private int postPwd;
	private int postCount;
	private int copyNo;
	private String fileName;
	private String fcName;

	public MiniHomePost() {}

	public MiniHomePost(int postNo, int homepyNo, String postWriter, int folderNo, String postType, String postTitle,
			String postContent, Date postCreateDT, int recommendCount, String postStatus, int postPwd, int postCount,
			int copyNo, String fileName, String fcName) {
		this.postNo = postNo;
		this.homepyNo = homepyNo;
		this.postWriter = postWriter;
		this.folderNo = folderNo;
		this.postType = postType;
		this.postTitle = postTitle;
		this.postContent = postContent;
		this.postCreateDT = postCreateDT;
		this.recommendCount = recommendCount;
		this.postStatus = postStatus;
		this.postPwd = postPwd;
		this.postCount = postCount;
		this.copyNo = copyNo;
		this.fileName = fileName;
		this.fcName = fcName;
	}

	public int getPostNo() {
		return postNo;
	}

	public void setPostNo(int postNo) {
		this.postNo = postNo;
	}

	public int getHomepyNo() {
		return homepyNo;
	}

	public void setHomepyNo(int homepyNo) {
		this.homepyNo = homepyNo;
	}

	public String getPostWriter() {
		return postWriter;
	}

	public void setPostWriter(String postWriter) {
		this.postWriter = postWriter;
	}

	public int getFolderNo() {
		return folderNo;
	}

	public void setFolderNo(int folderNo) {
		this.folderNo = folderNo;
	}

	public String getPostType() {
		return postType;
	}

	public void setPostType(String postType) {
		this.postType = postType;
	}

	public String getPostTitle() {
		return postTitle;
	}

	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}

	public String getPostContent() {
		return postContent;
	}

	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}

	public Date getPostCreateDT() {
		return postCreateDT;
	}

	public void setPostCreateDT(Date postCreateDT) {
		this.postCreateDT = postCreateDT;
	}

	public int getRecommendCount() {
		return recommendCount;
	}

	public void setRecommendCount(int recommendCount) {
		this.recommendCount = recommendCount;
	}

	public String getPostStatus() {
		return postStatus;
	}

	public void setPostStatus(String postStatus) {
		this.postStatus = postStatus;
	}

	public int getPostPwd() {
		return postPwd;
	}

	public void setPostPwd(int postPwd) {
		this.postPwd = postPwd;
	}

	public int getPostCount() {
		return postCount;
	}

	public void setPostCount(int postCount) {
		this.postCount = postCount;
	}

	public int getCopyNo() {
		return copyNo;
	}

	public void setCopyNo(int copyNo) {
		this.copyNo = copyNo;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFcName() {
		return fcName;
	}

	public void setFcName(String fcName) {
		this.fcName = fcName;
	}

	@Override
	public String toString() {
		return "MiniHomePost [postNo=" + postNo + ", homepyNo=" + homepyNo + ", postWriter=" + postWriter
				+ ", folderNo=" + folderNo + ", postType=" + postType + ", postTitle=" + postTitle + ", postContent="
				+ postContent + ", postCreateDT=" + postCreateDT + ", recommendCount=" + recommendCount
				+ ", postStatus=" + postStatus + ", postPwd=" + postPwd + ", postCount=" + postCount + ", copyNo="
				+ copyNo + ", fileName=" + fileName + ", fcName=" + fcName + "]";
	}
}
