/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tadspi3null.servletEstoque;

import com.tadspi3null.dao.DaoEstoque;
import com.tadspi3null.models.LivroFilial;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author mverissimo
 */
@WebServlet(name = "ServletEstoque", urlPatterns = {"/estoque"})
public class ServletEstoque extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher
        = request.getRequestDispatcher("WEB-INF/jsp/estoque.jsp");
        
        String id = request.getParameter("id");
        Long long_id = Long.parseLong(id);
        
        try {
            ArrayList<LivroFilial> listaLivroFilial = DaoEstoque.obterEstoque(long_id);

            request.setAttribute("listaLivroFilial", listaLivroFilial);

            
            dispatcher.forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ServletEstoque.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
            
    }
}
