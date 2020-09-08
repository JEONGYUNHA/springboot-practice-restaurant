package com.restaurant.springboot.service;

import com.restaurant.springboot.controller.KitchenController;
import com.restaurant.springboot.domain.Order;
import com.restaurant.springboot.dto.KitchenDto;
import com.restaurant.springboot.dto.OrderDto;
import com.restaurant.springboot.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Transactional
    public Long saveOrder(OrderDto orderDto) {

//        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
//
//        RestTemplate restTemplate = new RestTemplate(factory);
//        String url = "http://localhost:8080/api/v1/kitchen/newOrder";
//
//        KitchenDto newOrder = new KitchenDto(orderDto.getMenuName(), orderDto.getQuantity());
//        restTemplate.postForObject(url, newOrder, KitchenDto.class);

        return orderRepository.save(orderDto.toEntity()).getId();
    }

    public OrderDto findById(Long id) {
        Order entity = orderRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("주문 내역이 없습니다") );
        return new OrderDto(entity);
    }
}
