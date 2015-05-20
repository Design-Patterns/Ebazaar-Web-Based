/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group5.designpatters.ebazaar.service.impl;

import com.group5.designpatters.ebazaar.entities.Category;
import com.group5.designpatters.ebazaar.service.EbazaarService;
import com.group5.designpatters.ebazaar.service.EbazaarServiceFacade;
import java.util.List;

/**
 *
 * @author 984150
 */
public class EbazaarServiceFacadeImp implements EbazaarServiceFacade {

    private EbazaarService service;

    public EbazaarServiceFacadeImp(EbazaarService service) {
        this.service = service;
    }

    @Override
    public Category getCategoryById(int categoryId) {
        List<Category> categories = service.getCategoryList();
        for (Category c : categories) {
            if (c.getId() == categoryId) {
                return c;
            }
        }
        return null;
    }

}
