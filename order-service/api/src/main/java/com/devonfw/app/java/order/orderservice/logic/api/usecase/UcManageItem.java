package com.devonfw.app.java.order.orderservice.logic.api.usecase;

import com.devonfw.app.java.order.orderservice.logic.api.to.ItemEto;

public interface UcManageItem {

	boolean deleteItem(Long itemId);

	ItemEto saveItem(ItemEto item);

	void raiseItemPrice(String name, Double price);

}
