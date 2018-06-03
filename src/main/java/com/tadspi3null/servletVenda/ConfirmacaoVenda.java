/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tadspi3null.servletVenda;

import com.tadspi3null.dao.DaoVenda;
import com.tadspi3null.models.Cliente;
import com.tadspi3null.models.ItemVenda;
import com.tadspi3null.models.Livro;
import com.tadspi3null.models.Venda;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author mverissimo
 */
@WebServlet(name = "ConfirmacaoVenda", urlPatterns = {"/confirmacao-venda"})
public class ConfirmacaoVenda extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Armazena uma mensagem com o que ocorreu no ultimo evento
        // em uma Session HTTP
        HttpSession session = request.getSession();
        Long idVenda = Long.parseLong(request.getParameter("idVenda"));
        
        try {
            Venda venda = DaoVenda.obterPorId(idVenda);
            
            Double total = 0.0;
            for(ItemVenda itemVenda: venda.getListaItemVenda()) {
                total = total + itemVenda.getValorUnitario() * itemVenda.getQuantidade();
            }
            
            request.setAttribute("venda", venda);
            request.setAttribute("total", total);
            
            //Present the items for confirmation
            RequestDispatcher dispatcher
                = request.getRequestDispatcher("WEB-INF/jsp/confirmacao-venda.jsp");
            dispatcher.forward(request, response);
      
        } catch (SQLException ex) {
            Logger.getLogger(ConfirmacaoVenda.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
