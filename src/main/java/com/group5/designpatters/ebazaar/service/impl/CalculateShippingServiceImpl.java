/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group5.designpatters.ebazaar.service.impl;

import com.group5.designpatters.ebazaar.entities.Product;
import com.group5.designpatters.ebazaar.service.CalculateShippingService;

/**
 *
 * @author Odiljon Sattarov
 */
public class CalculateShippingServiceImpl implements CalculateShippingService {

    private double shippingPrice;

    @Override
    public void visit(Product p) {
        shippingPrice += p.getPrice();
    }

    @Override
    public double getShippingPrice() {
        return shippingPrice;
    }

}
