/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group5.designpatters.ebazaar.service.impl;

import com.group5.designpatters.ebazaar.dao.GenericDao;
import com.group5.designpatters.ebazaar.dao.impl.GenericDaoImpl;
import com.group5.designpatters.ebazaar.entities.Category;
import com.group5.designpatters.ebazaar.entities.Order;
import com.group5.designpatters.ebazaar.entities.Product;
import com.group5.designpatters.ebazaar.entities.Role;
import com.group5.designpatters.ebazaar.entities.User;
import com.group5.designpatters.ebazaar.service.EbazaarService;
import java.util.List;

/**
 *
 * @author Odiljon Sattarov
 */
public class EbazaarServiceImpl implements EbazaarService {

    private GenericDao<Product, Long> productDao = new GenericDaoImpl<Product, Long>();
    private GenericDao<Order, Long> orderDao = new GenericDaoImpl<Order, Long>();
    private GenericDao<User, Long> userDao = new GenericDaoImpl<User, Long>();
    private GenericDao<Role, Long> roleDao = new GenericDaoImpl<Role, Long>();
    private GenericDao<Category, Long> categoryDao = new GenericDaoImpl<Category, Long>();

    @Override
    public Product createProduct(Product p) {
        return productDao.create(p);
    }

    @Override
    public Order createOrder(Order o) {
        return orderDao.create(o);
    }

    @Override
    public Role createRole(Role r) {
        return roleDao.create(r);
    }

    @Override
    public Category createCategory(Category c) {
        return categoryDao.create(c);
    }

    @Override
    public User createUser(User u) {
        return userDao.create(u);
    }

    @Override
    public List<Product> getProductList() {
        return productDao.findAll(Product.class);
    }

    @Override
    public List<Order> getOrderList() {
        return orderDao.findAll(Order.class);
    }

    @Override
    public List<Role> getRoleList() {
        return roleDao.findAll(Role.class);
    }

    @Override
    public List<Category> getCategoryList() {
        return categoryDao.findAll(Category.class);
    }

    @Override
    public List<User> getUserList() {
        return userDao.findAll(User.class);
    }

}
