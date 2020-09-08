package com.restaurant.springboot.dto;


import com.restaurant.springboot.domain.Kitchen;
import lombok.*;


@NoArgsConstructor
@Builder
@Data
public class KitchenDto {

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
