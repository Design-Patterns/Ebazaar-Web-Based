/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group5.designpatters.ebazaar.utilities.iterator;

import com.group5.designpatters.ebazaar.entities.Product;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author 984150
 */
public class MyProductIterator implements Iterator<Product> {

    private List<Product> products;
    private int userId;
    private Product next;
    private int index;

    public MyProductIterator(List<Product> products, int userId) {
        this.products = products;
        this.userId = userId;
        this.index = 0;
    }

    private void setNext() {
        for (int i = index; i < products.size(); i++) {
            if (products.get(i).getUser().getId() == userId) {
                index = i + 1;
                next = products.get(i);
                break;
            }
        }
        next = null;
    }

    @Override
    public boolean hasNext() {
        
    }

    @Override
    public Product next() {
        return next;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
