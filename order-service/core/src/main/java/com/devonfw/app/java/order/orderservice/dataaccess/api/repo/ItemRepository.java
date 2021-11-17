package com.devonfw.app.java.order.orderservice.dataaccess.api.repo;

import com.devonfw.app.java.order.orderservice.dataaccess.api.ItemEntity;
import com.devonfw.app.java.order.orderservice.logic.api.to.ItemSearchCriteriaTo;
import com.devonfw.module.jpa.dataaccess.api.QueryUtil;
import com.devonfw.module.jpa.dataaccess.api.data.DefaultRepository;
import com.querydsl.jpa.impl.JPAQuery;

import static com.querydsl.core.alias.Alias.$;

import java.util.Iterator;
import java.util.Set;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;

public interface ItemRepository extends DefaultRepository<ItemEntity> {

	default Page<ItemEntity> findByCriteria(ItemSearchCriteriaTo criteria) {

		  ItemEntity alias = newDslAlias();
		  JPAQuery<ItemEntity> query = newDslQuery(alias);

		  String name = criteria.getName();
		  if (name != null && !name.isEmpty()) {
		    QueryUtil.get().whereString(query, $(alias.getName()), name, criteria.getNameOption());
		  }

		  String description = criteria.getDescription();
		  if (description != null && !description.isEmpty()) {
			  QueryUtil.get().whereString(query, $(alias.getDescription()), description, criteria.getDescriptionOption());
		  }

		  Double price = criteria.getPrice();
		  if (price != null) {
			  query.where($(alias.getPrice()).eq(price));
		  }

		  addOrderBy(query, alias, criteria.getPageable().getSort());

		  return QueryUtil.get().findPaginated(criteria.getPageable(), query, true);
		}

	public default void addOrderBy(JPAQuery<ItemEntity> query, ItemEntity alias, Sort sort) {
		if (sort != null && sort.isSorted()) {
			Iterator<Order> it = sort.iterator();
			while (it.hasNext()) {
				Order next = it.next();
				switch (next.getProperty()) {
				case "name":
					if (next.isAscending()) {
						query.orderBy($(alias.getName()).asc());
					} else {
						query.orderBy($(alias.getName()).desc());
					}
					break;
				case "description":
					if (next.isAscending()) {
						query.orderBy($(alias.getDescription()).asc());
					} else {
						query.orderBy($(alias.getDescription()).desc());
					}
					break;
				case "price":
					if (next.isAscending()) {
						query.orderBy($(alias.getPrice()).asc());
					} else {
						query.orderBy($(alias.getPrice()).desc());
					}
					break;
				default:
					throw new IllegalArgumentException("Sorted by the unknown property '" + next.getProperty() + "'");
				}
			}
		}
	}

	public Set<ItemEntity> findByName(String name);

}
