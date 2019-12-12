package com.kh.LatteWorld.minihome.model.vo;

public class MiniHomeFolder {
	private int folderNo;
	private int homepyNo;
	private String postType;
	private String postStatus;
	private String folderName;

	public MiniHomeFolder() {}

	public MiniHomeFolder(int folderNo, int homepyNo, String postType, String postStatus, String folderName) {
		this.folderNo = folderNo;
		this.homepyNo = homepyNo;
		this.postType = postType;
		this.postStatus = postStatus;
		this.folderName = folderName;
	}

	public int getFolderNo() {
		return folderNo;
	}

	public void setFolderNo(int folderNo) {
		this.folderNo = folderNo;
	}

	public int getHomepyNo() {
		return homepyNo;
	}

	public void setHomepyNo(int homepyNo) {
		this.homepyNo = homepyNo;
	}

	public String getPostType() {
		return postType;
	}

	public void setPostType(String postType) {
		this.postType = postType;
	}

	public String getPostStatus() {
		return postStatus;
	}

	public void setPostStatus(String postStatus) {
		this.postStatus = postStatus;
	}

	public String getFolderName() {
		return folderName;
	}

	public void setFolderName(String folderName) {
		this.folderName = folderName;
	}

	@Override
	public String toString() {
		return "MiniHomeFolder [folderNo=" + folderNo + ", homepyNo=" + homepyNo + ", postType=" + postType
				+ ", postStatus=" + postStatus + ", folderName=" + folderName + "]";
	}
}
