package com.delivery.service;

import com.delivery.model.entity.Restaurant;
import com.delivery.model.entity.User;
import org.hibernate.Session;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.io.Serializable;
import java.util.List;

public class UserService {
    Session session;

    public UserService(Session session){
        this.session = session;
    }

    public User getUser(int id){
        this.session.beginTransaction();
        User user = session.get(User.class, id);
        this.session.getTransaction().commit();
        return user;
    };

    public List<User> getUsers(){
        this.session.beginTransaction();
        CriteriaBuilder builder = this.session.getCriteriaBuilder();
        CriteriaQuery<User> criteria = builder.createQuery(User.class);
        criteria.from(User.class);
        this.session.getTransaction().commit();
        return this.session.createQuery(criteria).getResultList();
    }

    public User createUser(User user){
        this.session.beginTransaction();
        Serializable userCreatedId = session.save(user);
        User userCreated = session.get(User.class, userCreatedId);
        this.session.getTransaction().commit();
        return userCreated;
    }

    public User updateRestaurant(User user){
        this.session.beginTransaction();
        this.session.update(user);
        User updatedUser = session.get(User.class, user.getId());
        this.session.getTransaction().commit();
        return updatedUser;

    }

    public void deleteUser(User user){
        this.session.beginTransaction();
        this.session.delete(user);
        this.session.getTransaction().commit();
    }
}
