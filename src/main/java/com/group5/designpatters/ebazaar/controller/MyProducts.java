/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.group5.designpatters.ebazaar.controller;

import com.group5.designpatters.ebazaar.entities.Product;
import com.group5.designpatters.ebazaar.entities.User;
import com.group5.designpatters.ebazaar.service.EbazaarService;
import com.group5.designpatters.ebazaar.service.impl.EbazaarServiceImpl;
import com.group5.designpatters.ebazaar.utilities.iterator.MyProductIterator;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Rustam
 */
@WebServlet(name = "MyProducts", urlPatterns = {"/MyProducts"})
public class MyProducts extends HttpServlet {
    
    EbazaarService service = EbazaarServiceImpl.getInstance();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        List<Product> products = service.getProductList();
        User u = (User) request.getSession().getAttribute("user");
        
        Iterator<Product> i = new MyProductIterator(products, u.getId());
        request.setAttribute("iterator", i);
        request.getRequestDispatcher("myproducts.jsp").forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
