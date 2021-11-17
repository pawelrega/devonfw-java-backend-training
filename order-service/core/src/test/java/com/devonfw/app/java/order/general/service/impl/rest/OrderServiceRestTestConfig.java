package com.devonfw.app.java.order.general.service.impl.rest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.devonfw.app.java.order.orderservice.common.base.OrderServiceRestTestHelper;

@Configuration
public class OrderServiceRestTestConfig {

  @Bean
  public OrderServiceRestTestHelper orderServiceRestTestHelper() {
    OrderServiceRestTestHelper orderServiceRestTestHelper = new OrderServiceRestTestHelper();
    return orderServiceRestTestHelper;
  }

}
