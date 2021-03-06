package com.kitchen.springboot.domain;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Getter
@NoArgsConstructor
public class Kitchen implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String menuName;
    private int quantity;

    @Builder
    public Kitchen(Long id, String menuName, int quantity){
        this.id = id;
        this.menuName = menuName;
        this.quantity = quantity;
    }

}
