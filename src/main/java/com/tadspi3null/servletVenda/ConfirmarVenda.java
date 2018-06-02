/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tadspi3null.servletVenda;

import com.tadspi3null.models.Cliente;
import com.tadspi3null.models.Livro;
import java.io.IOException;
import java.util.HashMap;
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
@WebServlet(name = "ConfirmarVenda", urlPatterns = {"/confirmar-venda"})
public class ConfirmarVenda extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Armazena uma mensagem com o que ocorreu no ultimo evento
        // em uma Session HTTP
        HttpSession session = request.getSession();
        Cliente clienteVenda = (Cliente) session.getAttribute("clienteVenda");
        HashMap<Livro, Integer> shopCart = (HashMap<Livro, Integer>) session.getAttribute("shopCart");
        
        if (clienteVenda == null){
            //Sends the user back to the client selection
            RequestDispatcher dispatcher = request.getRequestDispatcher("/selecionar-cliente");
            dispatcher.forward(request,response);    
        }
        else if(shopCart.isEmpty()){
            //Sends the user back to the products selection
            RequestDispatcher dispatcher = request.getRequestDispatcher("/selecionar-livros");
            dispatcher.forward(request,response);  
        }
        else{
            session.setAttribute("shopCart", shopCart);
            //Present the items for confirmation
            RequestDispatcher dispatcher
               = request.getRequestDispatcher("WEB-INF/jsp/confirmar-venda.jsp");
            dispatcher.forward(request, response);
        }
    }
}
