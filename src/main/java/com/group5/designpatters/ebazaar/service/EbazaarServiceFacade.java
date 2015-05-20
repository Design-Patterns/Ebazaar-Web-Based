/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group5.designpatters.ebazaar.service;

import com.group5.designpatters.ebazaar.entities.Category;

/**
 *
 * @author 984150
 */
public interface EbazaarServiceFacade {
    
    public Category getCategoryById(int categoryId);
    
}
