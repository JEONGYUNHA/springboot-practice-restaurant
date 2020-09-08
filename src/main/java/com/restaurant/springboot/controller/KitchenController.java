package com.restaurant.springboot.controller;

import com.restaurant.springboot.dto.KitchenDto;
import com.restaurant.springboot.dto.OrderDto;
import com.restaurant.springboot.service.KitchenService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Slf4j
@EnableWebMvc
@RestController
@RequestMapping("/api/v1/order/kitchen")
public class KitchenController {

    @Autowired
    private KitchenService kitchenService;

//    @PutMapping(value = "/newOrder")
    public Long saveOrder(@RequestBody KitchenDto kitchenDto){
        log.info("saveOrder");
        return kitchenService.saveOrder(kitchenDto);
    }


}

