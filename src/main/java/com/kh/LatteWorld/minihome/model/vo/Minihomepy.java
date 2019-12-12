package com.kh.LatteWorld.minihome.model.vo;

import java.sql.Date;

public class Minihomepy {

	private int homepyNo;
	private String userId;
	private String miniHomeTitle;
	private String minihomeColor;
	private int totalCount;

	public Minihomepy() {}

	public Minihomepy(int homepyNo, String userId, String miniHomeTitle, String minihomeColor, int totalCount) {
		this.homepyNo = homepyNo;
		this.userId = userId;
		this.miniHomeTitle = miniHomeTitle;
		this.minihomeColor = minihomeColor;
		this.totalCount = totalCount;
	}

	public int getHomepyNo() {
		return homepyNo;
	}

	public void setHomepyNo(int homepyNo) {
		this.homepyNo = homepyNo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getMiniHomeTitle() {
		return miniHomeTitle;
	}

	public void setMiniHomeTitle(String miniHomeTitle) {
		this.miniHomeTitle = miniHomeTitle;
	}

	public String getMinihomeColor() {
		return minihomeColor;
	}

	public void setMinihomeColor(String minihomeColor) {
		this.minihomeColor = minihomeColor;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	@Override
	public String toString() {
		return "Minihomepy [homepyNo=" + homepyNo + ", userId=" + userId + ", miniHomeTitle=" + miniHomeTitle
				+ ", minihomeColor=" + minihomeColor + ", totalCount=" + totalCount + "]";
	}
}
