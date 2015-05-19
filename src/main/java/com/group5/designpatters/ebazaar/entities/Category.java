/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group5.designpatters.ebazaar.entities;

/**
 *
 * @authors Moh'd Rashed Obaidat  
 *          Odiljon Sattarov 
 *          Rustam Ishmatov
 */
public class Category {
   private long id;
   private String name;
   private String info;

    public Category() {
    }
   
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
   
   
   
}
