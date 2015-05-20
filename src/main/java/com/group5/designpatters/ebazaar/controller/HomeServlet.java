/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group5.designpatters.ebazaar.controller;

import com.group5.designpatters.ebazaar.dao.GenericDao;
import com.group5.designpatters.ebazaar.dao.impl.GenericDaoImpl;
import com.group5.designpatters.ebazaar.entities.Product;
import com.group5.designpatters.ebazaar.service.EbazaarService;
import com.group5.designpatters.ebazaar.service.impl.EbazaarServiceImpl;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
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

    private EbazaarService ebazaarService = new EbazaarServiceImpl();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("products", ebazaarService.getProductList());
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
