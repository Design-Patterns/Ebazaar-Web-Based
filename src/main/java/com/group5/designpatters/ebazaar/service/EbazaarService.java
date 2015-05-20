/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group5.designpatters.ebazaar.service;

import com.group5.designpatters.ebazaar.controller.model.OrderDto;
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

    public Product createOrUpdateProduct(Product p);

    public Order createOrUpdateOrder(long userId, List<OrderDto> orderDto);

    public Role createOrUpdateRole(Role r);

    public User createOrUpdateUser(User u);

    public Category createOrUpdateCategory(Category c);

    public List<Product> getProductList();

    public List<Order> getOrderList();

    public List<Role> getRoleList();

    public List<Category> getCategoryList();

    public List<User> getUserList();
    
    public Category getCategoryById(long id);
}
