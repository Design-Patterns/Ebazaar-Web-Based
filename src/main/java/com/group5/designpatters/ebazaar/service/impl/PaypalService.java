/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group5.designpatters.ebazaar.service.impl;

import com.group5.designpatters.ebazaar.service.PaymentService;

/**
 *
 * @author Odiljon Sattarov
 */
public class PaypalService implements PaymentService {

    private String emailId;
    private String password;

    public PaypalService(String emailId, String password) {
        this.emailId = emailId;
        this.password = password;
    }

    @Override
    public void pay(double amount) {
        System.out.println(amount + " paid using Paypal.");
    }

}
