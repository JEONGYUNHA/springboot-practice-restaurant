package com.restaurant.springboot.controller;

import com.restaurant.springboot.dto.KitchenDto;
import com.restaurant.springboot.dto.OrderDto;
import com.restaurant.springboot.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@EnableWebMvc
@RestController
@RequestMapping("/api/v1/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private KitchenController kitchenController;

    @PostMapping("customer")
    public Long saveOrder(@RequestBody OrderDto orderDto){
        orderService.saveOrder(orderDto);

        KitchenDto kitchenDto = new KitchenDto(orderDto.getMenuName(), orderDto.getQuantity());
        return kitchenController.saveOrder(kitchenDto);
    }

    @GetMapping("/customer/{id}")
    public OrderDto findById(@PathVariable Long id){

        return orderService.findById(id);
    }


}
