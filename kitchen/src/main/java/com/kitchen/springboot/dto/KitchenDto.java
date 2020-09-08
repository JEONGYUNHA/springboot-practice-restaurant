package com.kitchen.springboot.dto;


import com.kitchen.springboot.domain.Kitchen;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@Builder
@Data
public class KitchenDto implements Serializable {

    private String menuName;
    private int quantity;

    public KitchenDto(String menuName, int quantity) {
        this.menuName = menuName;
        this.quantity = quantity;
    }

    public Kitchen toEntity() {
        return Kitchen.builder()
                .menuName(menuName)
                .quantity(quantity)
                .build();
    }
}
