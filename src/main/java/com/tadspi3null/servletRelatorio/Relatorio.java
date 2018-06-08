/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tadspi3null.servletRelatorio;

import com.tadspi3null.dao.DaoFilial;
import com.tadspi3null.dao.DaoVenda;
import com.tadspi3null.models.Filial;
import com.tadspi3null.models.ItemVenda;
import com.tadspi3null.models.Venda;
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
@WebServlet(name = "Relatorio", urlPatterns = {"/relatorio"})
public class Relatorio extends HttpServlet {

  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher
           = request.getRequestDispatcher("WEB-INF/jsp/relatorio.jsp");
        
        try {
            ArrayList<Filial> listaFilial = DaoFilial.consultaFilial("");
            request.setAttribute("listaFilial", listaFilial);
            
            dispatcher.forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(Relatorio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Integer id = Integer.parseInt(request.getParameter("filiais"));
        
        try {
            ArrayList<Venda> listaVenda = DaoVenda.obterVendaFilial(id);
             request.setAttribute("listaVenda", listaVenda);
             
            Double total = 0.0;
            for(Venda venda: listaVenda){
                for(ItemVenda itemVenda: venda.getListaItemVenda()) {
                    total = total + itemVenda.getValorUnitario() * itemVenda.getQuantidade();
                }
            }
            request.setAttribute("total", total);
            RequestDispatcher dispatcher
              = request.getRequestDispatcher("WEB-INF/jsp/relatorio.jsp");
            dispatcher.forward(request, response);
            
        } catch (SQLException ex) {
            Logger.getLogger(Relatorio.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }


}
