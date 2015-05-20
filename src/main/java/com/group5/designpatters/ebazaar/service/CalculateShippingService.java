/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group5.designpatters.ebazaar.service;

import com.group5.designpatters.ebazaar.entities.Product;

/**
 *
 * @author Odiljon Sattarov
 */
public interface CalculateShippingService {
    public void visit(Product p);
    public double getShippingPrice();
}
