/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group5.designpatters.ebazaar.controller;

import com.group5.designpatters.ebazaar.entities.Product;
import com.group5.designpatters.ebazaar.entities.User;
import com.group5.designpatters.ebazaar.service.EbazaarService;
import com.group5.designpatters.ebazaar.service.EbazaarServiceFacade;
import com.group5.designpatters.ebazaar.service.impl.EbazaarServiceFacadeImp;
import com.group5.designpatters.ebazaar.service.impl.EbazaarServiceImpl;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 984150
 */
@WebServlet(name = "SaveProduct", urlPatterns = {"/SaveProduct"})
public class SaveProduct extends HttpServlet {

    private EbazaarService ebazaarService = new EbazaarServiceImpl();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        EbazaarServiceFacade sf = new EbazaarServiceFacadeImp(ebazaarService);

        Product p = new Product();

        if (request.getParameter("id") != null && !request.getParameter("id").isEmpty()) {
            p.setId(Integer.parseInt(request.getParameter("id")));
        }

        p.setDescription(request.getParameter("description"));
        p.setPrice(Double.parseDouble(request.getParameter("price")));
        p.setQuantity(Integer.parseInt(request.getParameter("quantity")));
        p.setTitle(request.getParameter("title"));

        p.setUser((User) request.getSession().getAttribute("user"));
        p.setCategory(sf.getCategoryById(Integer.parseInt(request.getParameter("category_id"))));

        ebazaarService.createProduct(p);

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
