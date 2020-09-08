package com.restaurant.springboot.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "order_table")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String menuName;
    private int menuPrice;
    private int quantity;

    @Builder
    public Order(Long id, String menuName, int menuPrice, int quantity){
        this.id = id;
        this.menuName = menuName;
        this.menuPrice = menuPrice;
        this.quantity = quantity;
    }
}
