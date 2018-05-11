/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tadspi3null.servletFilial;

import com.tadspi3null.dao.DaoFilial;
import com.tadspi3null.models.Filial;
import java.io.IOException;
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
 * @author Danilo
 */
@WebServlet(name = "DetalheFilial", urlPatterns = {"/detalhe-filial"})
public class DetalheFilial extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         
        String id = request.getParameter("id_filial");
        Integer int_id = Integer.parseInt(id);
        
        
        ArrayList<Filial> listaLivros = null;
        
        try {
            Filial filial = DaoFilial.consultaPorId(int_id);
            
            request.setAttribute("filial", filial);
            request.setAttribute("endereco", filial.getEndereco());
        } catch (SQLException ex) {
            Logger.getLogger(DetalheFilial.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        RequestDispatcher dispatcher = 
	    request.getRequestDispatcher("WEB-INF/jsp/detalhe-filial.jsp");
        dispatcher.forward(request, response);
    
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

}
