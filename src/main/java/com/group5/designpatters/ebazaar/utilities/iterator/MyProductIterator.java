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
    private long userId;
    private int index;

    public MyProductIterator(List<Product> products, long userId) {
        this.products = products;
        this.userId = userId;
        this.index = 0;
    }

    @Override
    public boolean hasNext() {
        for (int i = index; i < products.size(); i++) {
            if (products.get(i).getUser().getId() == userId) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Product next() {
        for (int i = index; i < products.size(); i++) {
            if (products.get(i).getUser().getId() == userId) {
                index = i + 1;
                return products.get(i);
            }
        }
        throw new RuntimeException("maximum limit");
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
