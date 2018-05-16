/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tadspi3null.servletCliente;

import com.tadspi3null.dao.DaoCliente;
import com.tadspi3null.models.Cliente;
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
@WebServlet(name = "ConsultarCliente", urlPatterns = {"/consultar-cliente"})
public class ConsultarCliente extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        ArrayList<Cliente> listaCliente = new ArrayList<>();
        
        try {
            listaCliente = DaoCliente.obterListaCliente();
            request.setAttribute("listaCliente", listaCliente);
        } catch (SQLException ex) {
            Logger.getLogger(ConsultarCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        RequestDispatcher dispatcher
           = request.getRequestDispatcher("WEB-INF/jsp/consultar-cliente.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

}
