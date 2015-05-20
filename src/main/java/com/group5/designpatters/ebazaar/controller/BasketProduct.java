/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group5.designpatters.ebazaar.controller;

import com.group5.designpatters.ebazaar.controller.model.OrderDto;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Rustam
 */
@WebServlet(name = "BasketProduct", urlPatterns = {"/BasketProduct"})
public class BasketProduct extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        if (session.getAttribute("basket") == null) {
            session.setAttribute("basket", new ArrayList<OrderDto>());
        }
        List<OrderDto> basket = (List<OrderDto>) session.getAttribute("basket");

        int productId = Integer.parseInt(request.getParameter("product_id"));
        OrderDto o = has(basket, productId);
        if (o == null) {
            basket.add(new OrderDto(Long.valueOf(productId), 1));
        } else {
            o.increaseQuantity();
        }

       
 
        request.getRequestDispatcher("index.html").forward(request, response);
    }

    private OrderDto has(List<OrderDto> list, int productId) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getProductId() == productId) {
                return list.get(i);
            }
        }
        return null;
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
