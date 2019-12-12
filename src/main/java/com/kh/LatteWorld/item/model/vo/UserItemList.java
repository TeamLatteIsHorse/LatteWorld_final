package com.kh.LatteWorld.item.model.vo;

public class UserItemList {
	private int itemListNo;
	private String userId;
	private int itemNo;
	private String itemUseStatus;
	
	public UserItemList() {}

	public UserItemList(int itemListNo, String userId, int itemNo, String itemUseStatus) {
		this.itemListNo = itemListNo;
		this.userId = userId;
		this.itemNo = itemNo;
		this.itemUseStatus = itemUseStatus;
	}

	public int getItemListNo() {
		return itemListNo;
	}

	public void setItemListNo(int itemListNo) {
		this.itemListNo = itemListNo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getItemNo() {
		return itemNo;
	}

	public void setItemNo(int itemNo) {
		this.itemNo = itemNo;
	}

	public String getItemUseStatus() {
		return itemUseStatus;
	}

	public void setItemUseStatus(String itemUseStatus) {
		this.itemUseStatus = itemUseStatus;
	}

	@Override
	public String toString() {
		return "UserItemList [itemListNo=" + itemListNo + ", userId=" + userId + ", itemNo=" + itemNo
				+ ", itemUseStatus=" + itemUseStatus + "]";
	}
	
}
