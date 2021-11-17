package com.devonfw.app.java.order.general.service.impl.rest;

import java.util.Set;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.devonfw.app.java.order.SpringBootApp;
import com.devonfw.app.java.order.general.common.base.test.DbTestHelper;
import com.devonfw.app.java.order.general.service.base.test.RestServiceTest;
import com.devonfw.app.java.order.orderservice.common.base.ItemTestData;
import com.devonfw.app.java.order.orderservice.common.base.OrderServiceRestTestHelper;
import com.devonfw.app.java.order.orderservice.dataaccess.api.repo.CustomerRepository;
import com.devonfw.app.java.order.orderservice.logic.api.Orderservice;
import com.devonfw.app.java.order.orderservice.logic.api.to.ItemEto;
import com.devonfw.app.java.order.orderservice.logic.api.to.OrderCto;
import com.devonfw.app.java.order.orderservice.service.api.rest.OrderserviceRestService;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = { SpringBootApp.class, OrderServiceRestTestConfig.class })
public class OrderServiceRestTest extends RestServiceTest {

	    /** Logger instance. */
	    private static final Logger LOG = LoggerFactory.getLogger(SecurityRestServiceImplTest.class);

	    @Inject
		private OrderServiceRestTestHelper helper;

		@Inject
		private OrderserviceRestService service;

		@Inject
		private DbTestHelper dbTestHelper;

		@Inject
		private Orderservice orderservice;

		@Inject
		private CustomerRepository customerRepository;

		@Override
		public void doSetUp() {
			super.doSetUp();
			dbTestHelper.resetDatabase();
		}

		@Override
		public void doTearDown() {
			this.service = null;
			super.doTearDown();
		}

		@Test
		public void shouldFindItemByName() {
			// given
			OrderCto order = this.helper.createDummyOrderCTO();
			this.service.saveOrder(order);
			// when
			Set<ItemEto> items = this.service.findItemByName(ItemTestData.CORN_NAME);
			// then
			assertThat(items).hasSize(1);
			assertThat(items.iterator().next().getName()).isEqualTo(ItemTestData.CORN_NAME);
		}
}
