package com.devonfw.app.java.order.orderservice.logic.api.usecase;

import java.util.Set;

import org.springframework.data.domain.Page;

import com.devonfw.app.java.order.orderservice.logic.api.to.ItemEto;
import com.devonfw.app.java.order.orderservice.logic.api.to.ItemSearchCriteriaTo;

public interface UcFindItem {

	ItemEto findItem(long id);

	Page<ItemEto> findItems(ItemSearchCriteriaTo criteria);

	/**
	 *
	 * Returns a set of items that match name
	 * @param name
	 * @return the {@link Set} of matching {@link ItemEto}s
	 */
	Set<ItemEto> findByName(String name);

}
