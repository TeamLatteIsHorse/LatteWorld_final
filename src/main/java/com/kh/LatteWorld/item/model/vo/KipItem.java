package com.kh.LatteWorld.item.model.vo;

public class KipItem {
	private int kipListNo;
	private String userId;
	private int itemNo;
	private String itemName;
	private int price;
	private String itemCategory;
	private String itemStatus;
	private String itemLink;
	
	public KipItem() {}

	public KipItem(int kipListNo, String userId, int itemNo, String itemName, int price, String itemCategory, String itemStatus,
			String itemLink) {
		this.kipListNo = kipListNo;
		this.userId = userId;
		this.itemNo = itemNo;
		this.itemName = itemName;
		this.price = price;
		this.itemCategory = itemCategory;
		this.itemStatus = itemStatus;
		this.itemLink = itemLink;
	}

	public int getKipListNo() {
		return kipListNo;
	}

	public void setKipListNo(int kipListNo) {
		this.kipListNo = kipListNo;
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

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getItemCategory() {
		return itemCategory;
	}

	public void setItemCategory(String itemCategory) {
		this.itemCategory = itemCategory;
	}

	public String getItemStatus() {
		return itemStatus;
	}

	public void setItemStatus(String itemStatus) {
		this.itemStatus = itemStatus;
	}

	public String getItemLink() {
		return itemLink;
	}

	public void setItemLink(String itemLink) {
		this.itemLink = itemLink;
	}

	@Override
	public String toString() {
		return "KipItem [kipListNo=" + kipListNo + ", userId=" + userId + ", itemNo=" + itemNo + ", itemName="
				+ itemName + ", price=" + price + ", itemCategory=" + itemCategory + ", itemStatus=" + itemStatus
				+ ", itemLink=" + itemLink + "]";
	}
	
}
