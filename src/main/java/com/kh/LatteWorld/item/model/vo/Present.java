package com.kh.LatteWorld.item.model.vo;

import java.sql.Date;

public class Present {
	private int presentListNo;
	private int itemNo;
	private String userId;
	private String itemCategory;
	private String itemName;
	private String itemLink;
	private String presentUserId;
	private Date presentDate;
	private String presentContent;
	private String presentStatus;
	
	public Present() {}

	public Present(int presentListNo, int itemNo, String userId, String itemCategory, String itemName, String itemLink,
			String presentUserId, Date presentDate, String presentContent, String presentStatus) {
		this.presentListNo = presentListNo;
		this.itemNo = itemNo;
		this.userId = userId;
		this.itemCategory = itemCategory;
		this.itemName = itemName;
		this.itemLink = itemLink;
		this.presentUserId = presentUserId;
		this.presentDate = presentDate;
		this.presentContent = presentContent;
		this.presentStatus = presentStatus;
	}

	public int getPresentListNo() {
		return presentListNo;
	}

	public void setPresentListNo(int presentListNo) {
		this.presentListNo = presentListNo;
	}

	public int getItemNo() {
		return itemNo;
	}

	public void setItemNo(int itemNo) {
		this.itemNo = itemNo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getItemCategory() {
		return itemCategory;
	}

	public void setItemCategory(String itemCategory) {
		this.itemCategory = itemCategory;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemLink() {
		return itemLink;
	}

	public void setItemLink(String itemLink) {
		this.itemLink = itemLink;
	}

	public String getPresentUserId() {
		return presentUserId;
	}

	public void setPresentUserId(String presentUserId) {
		this.presentUserId = presentUserId;
	}

	public Date getPresentDate() {
		return presentDate;
	}

	public void setPresentDate(Date presentDate) {
		this.presentDate = presentDate;
	}

	public String getPresentContent() {
		return presentContent;
	}

	public void setPresentContent(String presentContent) {
		this.presentContent = presentContent;
	}

	public String getPresentStatus() {
		return presentStatus;
	}

	public void setPresentStatus(String presentStatus) {
		this.presentStatus = presentStatus;
	}

	@Override
	public String toString() {
		return "Present [presentListNo=" + presentListNo + ", itemNo=" + itemNo + ", userId=" + userId
				+ ", itemCategory=" + itemCategory + ", itemName=" + itemName + ", itemLink=" + itemLink
				+ ", presentUserId=" + presentUserId + ", presentDate=" + presentDate + ", presentContent="
				+ presentContent + ", presentStatus=" + presentStatus + "]";
	}
	
}