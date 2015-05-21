/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group5.designpatters.ebazaar.controller;

import com.group5.designpatters.ebazaar.entities.Product;
import com.group5.designpatters.ebazaar.service.EbazaarService;
import com.group5.designpatters.ebazaar.service.impl.EbazaarServiceImpl;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 984150
 */
@WebServlet(name = "HomeServlet", urlPatterns = {"/index.html"})
public class HomeServlet extends HttpServlet {

    private EbazaarService ebazaarService = EbazaarServiceImpl.getInstance();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Product> products = ebazaarService.getProductList();
        List<Product> products2 = new ArrayList<Product>();

        if (request.getParameter("question") != null) {
            String question = request.getParameter("question").trim().toLowerCase();

            for (int i = 0; i < products.size(); i++) {
                Product p = products.get(i);
                if (p.getDescription().toLowerCase().contains(question) || p.getTitle().toLowerCase().contains(question)) {
                    products2.add(p);
                }
            }
            request.setAttribute("question", request.getParameter("question"));

        } else {
            products2 = products;
        }

        request.setAttribute("products", products2);
        request.getRequestDispatcher("main.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

}
