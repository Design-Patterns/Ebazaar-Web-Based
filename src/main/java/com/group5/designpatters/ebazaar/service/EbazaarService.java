/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group5.designpatters.ebazaar.service;

import com.group5.designpatters.ebazaar.entities.Category;
import com.group5.designpatters.ebazaar.entities.Order;
import com.group5.designpatters.ebazaar.entities.Product;
import com.group5.designpatters.ebazaar.entities.Role;
import com.group5.designpatters.ebazaar.entities.User;
import java.util.List;

/**
 *
 * @author Odiljon Sattarov
 */
public interface EbazaarService {

    public Product createProduct(Product p);

    public Order createOrder(Order o);

    public Role createRole(Role r);

    public User createOrUpdateUser(User u);

    public Category createCategory(Category c);

    public List<Product> getProductList();

    public List<Order> getOrderList();

    public List<Role> getRoleList();

    public List<Category> getCategoryList();

    public List<User> getUserList();
}
