/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group5.designpatters.ebazaar.entities;

import java.util.Date;

/**
 *
 * @authors Moh'd Rashed Obaidat  
 *          Odiljon Sattarov 
 *          Rustam Ishmatov
 */
public class Order {
    private long id;
    private User user;
    private Date date;

    public Order() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
    
}
