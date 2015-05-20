/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group5.designpatters.ebazaar.service.impl;

import com.group5.designpatters.ebazaar.controller.model.OrderDto;
import com.group5.designpatters.ebazaar.dao.GenericDao;
import com.group5.designpatters.ebazaar.dao.impl.GenericDaoImpl;
import com.group5.designpatters.ebazaar.entities.Category;
import com.group5.designpatters.ebazaar.entities.Order;
import com.group5.designpatters.ebazaar.entities.OrderProduct;
import com.group5.designpatters.ebazaar.entities.Product;
import com.group5.designpatters.ebazaar.entities.Role;
import com.group5.designpatters.ebazaar.entities.User;
import com.group5.designpatters.ebazaar.service.EbazaarService;
import com.group5.designpatters.ebazaar.utilities.HibernateUtil;
import java.util.Date;
import java.util.List;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Odiljon Sattarov
 */
public class EbazaarServiceImpl implements EbazaarService {

    private static EbazaarServiceImpl instance;
    private Transaction tx;
    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    private GenericDao<Product, Long> productDao = new GenericDaoImpl<Product, Long>();
    private GenericDao<Order, Long> orderDao = new GenericDaoImpl<Order, Long>();
    private GenericDao<User, Long> userDao = new GenericDaoImpl<User, Long>();
    private GenericDao<Role, Long> roleDao = new GenericDaoImpl<Role, Long>();
    private GenericDao<Category, Long> categoryDao = new GenericDaoImpl<Category, Long>();

    private EbazaarServiceImpl() {

    }

    @Override
    public Product createOrUpdateProduct(Product p) {
        tx = sessionFactory.getCurrentSession().beginTransaction();
        Product product;
        if (p.getId() == 0) {
            product = productDao.create(p);
        } else {
            product = productDao.update(p);
        }

        tx.commit();
        return product;
    }

    @Override
    public Order createOrUpdateOrder(long userId, List<OrderDto> orderDtoList) {
        tx = sessionFactory.getCurrentSession().beginTransaction();
        User user = userDao.findById(userId, User.class);
        Order order = new Order(user, new Date());

        if (orderDtoList.size() > 0) {
            for (OrderDto orderDto : orderDtoList) {
                Product product = productDao.findById(orderDto.getProductId(), Product.class);
                order.getOrderProductList().add(new OrderProduct(order, product, orderDto.getQuantity()));
            }
            orderDao.create(order);
        }

        tx.commit();
        return order;
    }

    @Override
    public Role createOrUpdateRole(Role r) {
        tx = sessionFactory.getCurrentSession().beginTransaction();
        Role role;
        if (r.getId() == 0) {
            role = roleDao.create(r);
        } else {
            role = roleDao.update(r);
        }
        tx.commit();
        return role;
    }

    @Override
    public Category createOrUpdateCategory(Category c) {
        tx = sessionFactory.getCurrentSession().beginTransaction();
        Category category;
        if (c.getId() == 0) {
            category = categoryDao.create(c);
        } else {
            category = categoryDao.update(c);
        }
        tx.commit();
        return category;
    }

    @Override
    public User createOrUpdateUser(User u) {
        tx = sessionFactory.getCurrentSession().beginTransaction();
        User user;
        if (u.getId() == 0) {
            user = userDao.create(u);
        } else {
            user = userDao.update(u);
        }
        tx.commit();
        return user;
    }

    @Override
    public List<Product> getProductList() {
        tx = sessionFactory.getCurrentSession().beginTransaction();
        List<Product> productList = productDao.findAll(Product.class);
        tx.commit();
        return productList;
    }

    @Override
    public List<Order> getOrderList() {
        tx = sessionFactory.getCurrentSession().beginTransaction();
        List<Order> orderList = orderDao.findAll(Order.class);
        tx.commit();
        return orderList;
    }

    @Override
    public List<Role> getRoleList() {
        tx = sessionFactory.getCurrentSession().beginTransaction();
        List<Role> roleList = roleDao.findAll(Role.class);
        tx.commit();
        return roleList;
    }

    @Override
    public List<Category> getCategoryList() {
        tx = sessionFactory.getCurrentSession().beginTransaction();
        List<Category> categoryList = categoryDao.findAll(Category.class);
        tx.commit();
        return categoryList;
    }

    @Override
    public List<User> getUserList() {
        tx = sessionFactory.getCurrentSession().beginTransaction();
        List<User> userList = userDao.findAll(User.class);
        tx.commit();
        return userList;
    }

    @Override
    public Category getCategoryById(long id) {
        tx = sessionFactory.getCurrentSession().beginTransaction();
        Category category = categoryDao.findById(id, Category.class);
        tx.commit();
        return category;
    }

    public static EbazaarService getInstance() {
        if (instance == null) {
            synchronized (EbazaarService.class) {
                if (instance == null) {
                    instance = new EbazaarServiceImpl();
                }
            }
        }
        return instance;
    }
}
