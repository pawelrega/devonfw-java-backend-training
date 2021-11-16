package com.devonfw.app.java.order.orderservice.dataaccess.api.repo;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import com.devonfw.app.java.order.orderservice.dataaccess.api.ItemEntity;
import com.devonfw.module.test.common.base.ComponentTest;

@SpringBootTest( webEnvironment = WebEnvironment.DEFINED_PORT)
public class ItemRepositoryTest extends ComponentTest{

	@Inject
	  private ItemRepository itemRepository;

	  @Test
	  public void shouldFindAllItems() {
	    // when
	    List<ItemEntity> foundItems = this.itemRepository.findAll();

	    // then
	    assertThat(foundItems).hasSize(1);
	  }

}
