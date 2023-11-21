package com.delivery.model.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name = "order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToMany(mappedBy = "orders")
    private Collection<Food> foods = new ArrayList<>();

    public Collection<Food> getFoods() {
        return foods;
    }

    public void setFoods(Collection<Food> foods) {
        this.foods = foods;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Order(Integer id, Collection<Food> foods) {
        this.id = id;
        this.foods = foods;
    }
}