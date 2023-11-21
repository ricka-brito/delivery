package com.delivery.model.entity;

import com.delivery.util.PasswordUtil;

import javax.persistence.*;
import java.security.NoSuchAlgorithmException;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "restaurant_owner")
    private Boolean restaurantOwner;



    public User() {
    }

    public User(String username, String password) {
        try {
            this.username = username;
            this.password = PasswordUtil.hash(password);
            this.restaurantOwner = false;
        } catch (NoSuchAlgorithmException e){
            e.printStackTrace();
        }

    }
    public User(String username, String password, boolean restaurantOwner){
        try {
            this.username = username;
            this.password = PasswordUtil.hash(password);
            this.restaurantOwner = restaurantOwner;
        } catch (NoSuchAlgorithmException e){
            e.printStackTrace();
        }
    }

    public User(int id, String username, String password, boolean restaurantOwner){
        try {
            this.id = id;
            this.username = username;
            this.password = PasswordUtil.hash(password);
            this.restaurantOwner = restaurantOwner;
        } catch (NoSuchAlgorithmException e){
            e.printStackTrace();
        }
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        try {
            this.password = PasswordUtil.hash(password);
        }
        catch (NoSuchAlgorithmException e){
            e.printStackTrace();
        }
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getRestaurantOwner() {
        return restaurantOwner;
    }

    public void setRestaurantOwner(Boolean restaurantOwner) {
        this.restaurantOwner = restaurantOwner;
    }


}