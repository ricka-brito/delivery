package com.delivery.service;

import com.delivery.model.entity.Restaurant;
import org.hibernate.Session;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.io.Serializable;
import java.util.List;

public class RestaurantService {

    Session session;

    public RestaurantService(Session session){
        this.session = session;
    }

    public Restaurant getRestaurant(int id){
        this.session.beginTransaction();
        Restaurant restaurant = session.get(Restaurant.class, id);
        this.session.getTransaction().commit();
        return restaurant;
    };

    public List<Restaurant> getRestaurants(){
        this.session.beginTransaction();
        CriteriaBuilder builder = this.session.getCriteriaBuilder();
        CriteriaQuery<Restaurant> criteria = builder.createQuery(Restaurant.class);
        criteria.from(Restaurant.class);
        this.session.getTransaction().commit();
        return this.session.createQuery(criteria).getResultList();
    }

    public Restaurant createRestaurant(Restaurant restaurant){
        this.session.beginTransaction();
        Serializable restaurantCreatedId = session.save(restaurant);
        Restaurant restaurantCreated = session.get(Restaurant.class, restaurantCreatedId);
        this.session.getTransaction().commit();
        return restaurantCreated;
    }

    public Restaurant updateRestaurant(Restaurant restaurant){
        this.session.beginTransaction();
        this.session.update(restaurant);
        Restaurant updatedRestaurant = session.get(Restaurant.class, restaurant.getId());
        this.session.getTransaction().commit();
        return updatedRestaurant;

    }

    public void deleteRestaurant(Restaurant restaurant){
        this.session.beginTransaction();
        this.session.delete(restaurant);
        this.session.getTransaction().commit();
    }
}
