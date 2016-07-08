package com.superz.study.bean;

import java.util.HashMap;
import java.util.Map;

public class ItemBill {
	Map<Integer, Item> bill = new HashMap<>();
	int itemCount = 0;

	int i;

	public ItemBill() {
		i = 0;
	}

	public ItemBill(Map<Integer, Item> bill, int itemCount) {
		super();
		this.bill = bill;
		this.itemCount = itemCount;
	}

	public Map<Integer, Item> getBill() {
		return bill;
	}

	public void setBill(Item item) {
		this.bill.put(this.i++, item);
		this.bill = bill;
		this.itemCount = i;

	}

	public int getItemCount() {
		return itemCount;
	}

	public void setItemCount(int itemCount) {
		this.itemCount = itemCount;
	}

	@Override
	public String toString() {
		return "ItemBill [bill=" + bill + ", itemCount=" + itemCount + "]";
	}

}
