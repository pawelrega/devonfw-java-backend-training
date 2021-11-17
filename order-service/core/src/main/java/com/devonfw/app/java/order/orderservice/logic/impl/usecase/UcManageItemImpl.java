package com.devonfw.app.java.order.orderservice.logic.impl.usecase;

import com.devonfw.app.java.order.orderservice.dataaccess.api.ItemEntity;
import com.devonfw.app.java.order.orderservice.logic.api.to.ItemEto;
import com.devonfw.app.java.order.orderservice.logic.api.usecase.UcManageItem;
import com.devonfw.app.java.order.orderservice.logic.base.usecase.AbstractItemUc;
import org.springframework.util.CollectionUtils;
import java.util.Objects;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UcManageItemImpl extends AbstractItemUc implements UcManageItem{

	private static final Logger LOG = LoggerFactory.getLogger(UcManageItemImpl.class);

	@Override
	public boolean deleteItem(Long itemId) {
		ItemEntity item = getItemRepository().find(itemId);
	    getItemRepository().delete(item);
	    LOG.debug("The item with id '{}' has been deleted.", itemId);
	    return true;
	}

	@Override
	public ItemEto saveItem(ItemEto item) {
		Objects.requireNonNull(item, "item");

	    ItemEntity itemEntity = getBeanMapper().map(item, ItemEntity.class);

	    // initialize, validate itemEntity here if necessary
	    ItemEntity resultEntity = getItemRepository().save(itemEntity);
	    LOG.debug("Item with id '{}' has been created.", resultEntity.getId());
	    return getBeanMapper().map(resultEntity, ItemEto.class);
	}

	@Override
	public void raiseItemPrice(String name, Double price) {
		Set<ItemEto> itemsToReprice = getBeanMapper().mapSet(getItemRepository().findByName(name), ItemEto.class);
	    if (!CollectionUtils.isEmpty(itemsToReprice)) {
	      itemsToReprice.stream().forEach(item -> {
	        item.setPrice(item.getPrice() + price);
	        saveItem(item);
	      });
	    }
	}

}
