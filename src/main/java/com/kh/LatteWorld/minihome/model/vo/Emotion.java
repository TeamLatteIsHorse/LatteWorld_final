package com.kh.LatteWorld.minihome.model.vo;

public class Emotion {
	
	private int homepyNo;
	private int eNum;
	private String eName;
	private String eImages;

	public Emotion() {}

	public Emotion(int homepyNo, int eNum, String eName, String eImages) {
		this.homepyNo = homepyNo;
		this.eNum = eNum;
		this.eName = eName;
		this.eImages = eImages;
	}

	public int getHomepyNo() {
		return homepyNo;
	}

	public void setHomepyNo(int homepyNo) {
		this.homepyNo = homepyNo;
	}

	public int geteNum() {
		return eNum;
	}

	public void seteNum(int eNum) {
		this.eNum = eNum;
	}

	public String geteName() {
		return eName;
	}

	public void seteName(String eName) {
		this.eName = eName;
	}

	public String geteImages() {
		return eImages;
	}

	public void seteImages(String eImages) {
		this.eImages = eImages;
	}

	@Override
	public String toString() {
		return "Emotion [homepyNo=" + homepyNo + ", eNum=" + eNum + ", eName=" + eName + ", eImages=" + eImages + "]";
	}
}
