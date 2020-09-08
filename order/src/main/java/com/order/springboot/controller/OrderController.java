package com.order.springboot.controller;

import com.order.springboot.dto.OrderDto;
import com.order.springboot.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("customer")
    public Long saveOrder(@RequestBody OrderDto orderDto){
        return orderService.saveOrder(orderDto);
    }

    @GetMapping("/customer/{id}")
    public OrderDto findById(@PathVariable Long id){

        return orderService.findById(id);
    }


}
