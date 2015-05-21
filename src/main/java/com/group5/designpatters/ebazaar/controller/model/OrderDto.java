/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group5.designpatters.ebazaar.controller.model;

import com.group5.designpatters.ebazaar.entities.Product;
import com.group5.designpatters.ebazaar.service.impl.EbazaarServiceImpl;

/**
 *
 * @author Odiljon Sattarov
 */
public class OrderDto {

    private Long productId;
    private int quantity;

    public OrderDto(Long productId, int quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }

    public Long getProductId() {
        return productId;
    }
    
    public Product getProduct() {
        return EbazaarServiceImpl.getInstance().getProductById(productId);
    }

    public int getQuantity() {
        return quantity;
    }

    public void increaseQuantity() {
        quantity++;
    }

}
