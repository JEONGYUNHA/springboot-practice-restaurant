package com.restaurant.springboot.service;

import com.restaurant.springboot.dto.KitchenDto;
import com.restaurant.springboot.repository.KitchenRepository;
import com.restaurant.springboot.repository.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class KitchenService {

    @Autowired
    private KitchenRepository kitchenRepository;

    public Long saveOrder(KitchenDto kitchenDto) {

        log.info("주문한 음식: {}",kitchenDto.getMenuName());
        log.info("개수: {}",kitchenDto.getQuantity());
        return kitchenRepository.save(kitchenDto.toEntity()).getId();
    }
}
