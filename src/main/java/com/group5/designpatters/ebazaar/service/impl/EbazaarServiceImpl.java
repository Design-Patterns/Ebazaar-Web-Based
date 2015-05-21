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
import java.util.Date;
import java.util.List;

/**
 *
 * @author Odiljon Sattarov
 */
public class EbazaarServiceImpl implements EbazaarService {

    private static EbazaarServiceImpl instance;
    private GenericDao<Product, Long> productDao = new GenericDaoImpl<Product, Long>();
    private GenericDao<Order, Long> orderDao = new GenericDaoImpl<Order, Long>();
    private GenericDao<User, Long> userDao = new GenericDaoImpl<User, Long>();
    private GenericDao<Role, Long> roleDao = new GenericDaoImpl<Role, Long>();
    private GenericDao<Category, Long> categoryDao = new GenericDaoImpl<Category, Long>();

    private EbazaarServiceImpl() {

    }

    @Override
    public Product createOrUpdateProduct(Product p) {
        Product product;
        if (p.getId() == 0) {
            product = productDao.create(p);
        } else {
            product = productDao.update(p);
        }
        return product;
    }

    @Override
    public Order createOrUpdateOrder(List<OrderDto> orderDtoList, Object... obj) {
        User user = null;
        if (obj.length > 0) {
            if (!(obj[0] instanceof Long)) {
                throw new IllegalArgumentException("...");
            }
            user = userDao.findById((Long) obj[0], User.class);
        }

        Order order = new Order(user, new Date());

        if (orderDtoList.size() > 0) {
            for (OrderDto orderDto : orderDtoList) {
                Product product = productDao.findById(orderDto.getProductId(), Product.class);
                order.getOrderProductList().add(new OrderProduct(order, product, orderDto.getQuantity()));
            }
            orderDao.create(order);
        }
        return order;
    }

    @Override
    public Role createOrUpdateRole(Role r) {
        Role role;
        if (r.getId() == 0) {
            role = roleDao.create(r);
        } else {
            role = roleDao.update(r);
        }
        return role;
    }

    @Override
    public Category createOrUpdateCategory(Category c) {
        Category category;
        if (c.getId() == 0) {
            category = categoryDao.create(c);
        } else {
            category = categoryDao.update(c);
        }
        return category;
    }

    @Override
    public User createOrUpdateUser(User u) {
        User user;
        if (u.getId() == 0) {
            user = userDao.create(u);
        } else {
            user = userDao.update(u);
        }
        return user;
    }

    @Override
    public List<Product> getProductList() {
        List<Product> productList = productDao.findAll(Product.class);
        return productList;
    }

    @Override
    public List<Order> getOrderList() {
        List<Order> orderList = orderDao.findAll(Order.class);
        return orderList;
    }

    @Override
    public List<Role> getRoleList() {
        List<Role> roleList = roleDao.findAll(Role.class);
        return roleList;
    }

    @Override
    public List<Category> getCategoryList() {
        List<Category> categoryList = categoryDao.findAll(Category.class);
        return categoryList;
    }

    @Override
    public List<User> getUserList() {
        List<User> userList = userDao.findAll(User.class);
        return userList;
    }

    @Override
    public Category getCategoryById(long id) {
        Category category = categoryDao.findById(id, Category.class);
        return category;
    }

    @Override
    public Product getProductById(long id) {
        Product product = productDao.findById(id, Product.class);
        return product;
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
