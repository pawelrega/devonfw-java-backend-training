package com.devonfw.app.java.order.orderservice.service.impl.rest;

import java.util.Set;

import javax.inject.Inject;
import javax.inject.Named;

import com.devonfw.app.java.order.orderservice.logic.api.Orderservice;
import com.devonfw.app.java.order.orderservice.logic.api.to.ItemEto;
import com.devonfw.app.java.order.orderservice.logic.api.to.ItemSearchCriteriaTo;
import com.devonfw.app.java.order.orderservice.logic.api.to.OrderCto;
import com.devonfw.app.java.order.orderservice.service.api.rest.OrderserviceRestService;

@Named("OrderserviceRestService")
public class OrderserviceRestServiceImpl implements OrderserviceRestService {

	@Inject
	Orderservice orderservice;

	@Override
	public Set<ItemEto> findItemByName(String name) {
		return this.orderservice.findByName(name);
	}

	@Override
	public OrderCto saveOrder(OrderCto order) {
		return this.orderservice.saveOrder(order);
	}

}
