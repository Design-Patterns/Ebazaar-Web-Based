/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group5.designpatters.ebazaar.service;

import com.group5.designpatters.ebazaar.entities.Product;
import com.group5.designpatters.ebazaar.service.impl.CalculateShippingServiceImpl;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Odiljon Sattarov
 */
public class ShoppingCardService {

    private List<Product> products;
    private CalculateShippingService shippingService;

    public ShoppingCardService() {
        this.products = new ArrayList<Product>();
        this.shippingService = new CalculateShippingServiceImpl();
    }

    public void addProduct(Product p) {
        products.add(p);
    }

    public void removeProduct(Product p) {
        products.remove(p);
    }

    public double calculateTotalPrice() {
        double sum = 0;
        for (Product p : products) {
            shippingService.visit(p);
            sum += p.getPrice() * p.getQuantity();
        }

        return sum + shippingService.getShippingPrice();
    }

}
