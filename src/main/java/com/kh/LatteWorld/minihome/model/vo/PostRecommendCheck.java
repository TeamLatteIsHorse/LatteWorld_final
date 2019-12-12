package com.kh.LatteWorld.minihome.model.vo;

public class PostRecommendCheck {
	private int postNo;
	private String userId;
	private int rCheck;

	public PostRecommendCheck() {}

	public PostRecommendCheck(int postNo, String userId, int rCheck) {
		this.postNo = postNo;
		this.userId = userId;
		this.rCheck = rCheck;
	}

	public int getPostNo() {
		return postNo;
	}

	public void setPostNo(int postNo) {
		this.postNo = postNo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getrCheck() {
		return rCheck;
	}

	public void setrCheck(int rCheck) {
		this.rCheck = rCheck;
	}

	@Override
	public String toString() {
		return "PostRecommendCheck [postNo=" + postNo + ", userId=" + userId + ", rCheck=" + rCheck + "]";
	}
}
