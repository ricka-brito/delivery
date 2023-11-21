package com.delivery;

import com.delivery.model.entity.Food;
import com.delivery.model.entity.Order;
import com.delivery.model.entity.Restaurant;
import com.delivery.model.entity.User;
import com.delivery.service.RestaurantService;
import com.delivery.util.HibernateUtil;
import com.delivery.util.PasswordUtil;
import org.hibernate.Session;

import java.io.IOException;
import java.net.URISyntaxException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws URISyntaxException, IOException, ClassNotFoundException, NoSuchAlgorithmException {

        HibernateUtil db = new HibernateUtil();
//
//        RestaurantService restaurantService = new RestaurantService(db.getSession());
//
//        for(Restaurant r: restaurantService.getRestaurants()){
//            System.out.println(r);
//        }
//        System.out.println(restaurantService.getRestaurant(1));
//
//        restaurantService.createRestaurant(new Restaurant("Maria", 10.2, 10.3));

        Session session = db.getSession();

        session.beginTransaction();
        Food comida = new Food("Panqueca");
        session.save(comida);
        session.save(new Order(1, new ArrayList<Food>((Collection<? extends Food>) comida)));
        System.out.println(session.get(Food.class, 1));
        session.getTransaction().commit();




    }
}
