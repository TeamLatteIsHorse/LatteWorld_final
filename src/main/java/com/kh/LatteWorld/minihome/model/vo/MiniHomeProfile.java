package com.kh.LatteWorld.minihome.model.vo;

import java.sql.Date;

public class MiniHomeProfile {
	
	private int profileNum;
	private int homepyNo;
	private String profileContent;
	private Date profileDate;
	private String profileStatus;
	private String profileImage;

	public MiniHomeProfile() {}

	public MiniHomeProfile(int profileNum, int homepyNo, String profileImage, String profileContent, Date profileDate,
			String profileStatus, String filePath) {
		this.profileNum = profileNum;
		this.homepyNo = homepyNo;
		this.profileContent = profileContent;
		this.profileDate = profileDate;
		this.profileStatus = profileStatus;
		this.profileImage = filePath;
	}

	public int getProfileNum() {
		return profileNum;
	}

	public void setProfileNum(int profileNum) {
		this.profileNum = profileNum;
	}

	public int getHomepyNo() {
		return homepyNo;
	}

	public void setHomepyNo(int homepyNo) {
		this.homepyNo = homepyNo;
	}

	public String getProfileContent() {
		return profileContent;
	}

	public void setProfileContent(String profileContent) {
		this.profileContent = profileContent;
	}

	public Date getProfileDate() {
		return profileDate;
	}

	public void setProfileDate(Date profileDate) {
		this.profileDate = profileDate;
	}

	public String getProfileStatus() {
		return profileStatus;
	}

	public void setProfileStatus(String profileStatus) {
		this.profileStatus = profileStatus;
	}

	public String getProfileImage() {
		return profileImage;
	}

	public void setProfileImage(String profileImage) {
		this.profileImage = profileImage;
	}

	@Override
	public String toString() {
		return "MiniHomeProfile [profileNum=" + profileNum + ", homepyNo=" + homepyNo + ", profileContent="
				+ profileContent + ", profileDate=" + profileDate + ", profileStatus=" + profileStatus
				+ ", profileImage=" + profileImage + "]";
	}
}
