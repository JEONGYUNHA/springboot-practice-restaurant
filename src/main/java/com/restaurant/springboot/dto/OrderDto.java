package com.restaurant.springboot.dto;

import com.restaurant.springboot.domain.Order;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class OrderDto {

    private String menuName;
    private int menuPrice;
    private int quantity;

    public OrderDto(Order entity) {
        this.menuName = entity.getMenuName();
        this.menuPrice = entity.getMenuPrice();
        this.quantity = entity.getQuantity();
    }

    public Order toEntity() {
        return Order.builder()
                .menuName(menuName)
                .menuPrice(menuPrice)
                .quantity(quantity)
                .build();
    }
}
