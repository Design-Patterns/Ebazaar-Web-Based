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
public class CategoryProductIterator implements Iterator<Product> {

    private List<Product> products;
    private int categoryId;
    private int index;

    public CategoryProductIterator(List<Product> products, int categoryId) {
        this.products = products;
        this.categoryId = categoryId;
        this.index = 0;
    }

    @Override
    public boolean hasNext() {
        for (int i = index; i < products.size(); i++) {
            if (products.get(i).getCategory().getId() == categoryId) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Product next() {
        for (int i = index; i < products.size(); i++) {
            if (products.get(i).getCategory().getId() == categoryId) {
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
