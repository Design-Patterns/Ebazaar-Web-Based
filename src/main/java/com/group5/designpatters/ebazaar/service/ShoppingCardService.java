/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group5.designpatters.ebazaar.service;

import com.group5.designpatters.ebazaar.entities.Order;
import com.group5.designpatters.ebazaar.entities.OrderProduct;
import com.group5.designpatters.ebazaar.entities.Product;
import com.group5.designpatters.ebazaar.service.impl.CalculateShippingServiceImpl;

/**
 *
 * @author Odiljon Sattarov
 */
public class ShoppingCardService {

    private CalculateShippingService shippingService;

    public ShoppingCardService() {
        this.shippingService = new CalculateShippingServiceImpl();
    }

    public double calculateTotalPrice(Order order) {
        double sum = 0;
        for (OrderProduct orderProduct : order.getOrderProductList()) {
            Product p = orderProduct.getProduct();
            shippingService.visit(p);
            sum += p.getPrice() * p.getQuantity();
        }

        return sum + shippingService.getShippingPrice();
    }
}
