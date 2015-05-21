/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group5.designpatters.ebazaar.service;

import com.group5.designpatters.ebazaar.controller.model.OrderDto;
import com.group5.designpatters.ebazaar.entities.Product;
import com.group5.designpatters.ebazaar.service.impl.CalculateShippingServiceImpl;
import java.util.List;

/**
 *
 * @author Odiljon Sattarov
 */
public class ShoppingCardService {

    private static ShoppingCardService instance;
    private CalculateShippingService shippingService;

    public ShoppingCardService() {
        this.shippingService = new CalculateShippingServiceImpl();
    }

    public double calculateTotalPrice(List<OrderDto> orderDtos) {
        double sum = 0;
        for (OrderDto orderDto : orderDtos) {
            Product p = orderDto.getProduct();
            shippingService.visit(p);
            sum += p.getPrice() * orderDto.getQuantity();
        }

        return sum + shippingService.getShippingPrice();
    }

    public static ShoppingCardService getInstance() {
        if (instance == null) {
            synchronized (ShoppingCardService.class) {
                if (instance == null) {
                    instance = new ShoppingCardService();
                }
            }
        }
        return instance;
    }
}
