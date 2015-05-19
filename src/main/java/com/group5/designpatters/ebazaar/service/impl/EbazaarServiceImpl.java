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
import com.group5.designpatters.ebazaar.utilities.HibernateUtil;
import java.util.List;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Odiljon Sattarov
 */
public class EbazaarServiceImpl implements EbazaarService {

    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    private GenericDao<Product, Long> productDao = new GenericDaoImpl<Product, Long>();
    private GenericDao<Order, Long> orderDao = new GenericDaoImpl<Order, Long>();
    private GenericDao<User, Long> userDao = new GenericDaoImpl<User, Long>();
    private GenericDao<Role, Long> roleDao = new GenericDaoImpl<Role, Long>();
    private GenericDao<Category, Long> categoryDao = new GenericDaoImpl<Category, Long>();

    @Override
    public Product createProduct(Product p) {
        Transaction tx = sessionFactory.getCurrentSession().beginTransaction();
        Product product = productDao.create(p);
        tx.commit();
        return product;
    }

    @Override
    public Order createOrder(Order o) {
        Transaction tx = sessionFactory.getCurrentSession().beginTransaction();
        Order order = orderDao.create(o);
        tx.commit();
        return order;
    }

    @Override
    public Role createRole(Role r) {
        Transaction tx = sessionFactory.getCurrentSession().beginTransaction();
        Role role = roleDao.create(r);
        tx.commit();
        return role;
    }

    @Override
    public Category createCategory(Category c) {
        Transaction tx = sessionFactory.getCurrentSession().beginTransaction();
        Category category = categoryDao.create(c);
        tx.commit();
        return category;
    }

    @Override
    public User createUser(User u) {
        Transaction tx = sessionFactory.getCurrentSession().beginTransaction();
        User user = userDao.create(u);
        tx.commit();
        return user;
    }

    @Override
    public List<Product> getProductList() {
        Transaction tx = sessionFactory.getCurrentSession().beginTransaction();
        List<Product> productList = productDao.findAll(Product.class);
        tx.commit();
        return productList;
    }

    @Override
    public List<Order> getOrderList() {
        Transaction tx = sessionFactory.getCurrentSession().beginTransaction();
        List<Order> orderList = orderDao.findAll(Order.class);
        tx.commit();
        return orderList;
    }

    @Override
    public List<Role> getRoleList() {
        Transaction tx = sessionFactory.getCurrentSession().beginTransaction();
        List<Role> roleList = roleDao.findAll(Role.class);
        tx.commit();
        return roleList;
    }

    @Override
    public List<Category> getCategoryList() {
        Transaction tx = sessionFactory.getCurrentSession().beginTransaction();
        List<Category> categoryList = categoryDao.findAll(Category.class);
        tx.commit();
        return categoryList;
    }

    @Override
    public List<User> getUserList() {
        Transaction tx = sessionFactory.getCurrentSession().beginTransaction();
        List<User> userList = userDao.findAll(User.class);
        tx.commit();
        return userList;
    }

}
