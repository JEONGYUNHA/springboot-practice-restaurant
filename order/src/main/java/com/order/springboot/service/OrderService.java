package com.order.springboot.service;

import com.kitchen.springboot.dto.KitchenDto;
import com.order.springboot.domain.Order;
import com.order.springboot.dto.OrderDto;
import com.order.springboot.repository.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Transactional
    public Long saveOrder(OrderDto orderDto) {

        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();

        RestTemplate restTemplate = new RestTemplate(factory);
        String url = "http://localhost:8081/api/v1/order/kitchen/newOrder";

        KitchenDto newOrder = new KitchenDto(orderDto.getMenuName(), orderDto.getQuantity());
        Long id = restTemplate.postForObject(url, newOrder, Long.class);

        log.info("id",id);
        return orderRepository.save(orderDto.toEntity()).getId();
    }

    public OrderDto findById(Long id) {
        Order entity = orderRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("주문 내역이 없습니다"));
        return new OrderDto(entity);
    }
}
