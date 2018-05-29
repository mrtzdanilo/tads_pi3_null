/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tadspi3null.servletVenda;

import com.tadspi3null.dao.DaoLivro;
import com.tadspi3null.models.Cliente;
import com.tadspi3null.models.Livro;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
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
@WebServlet(name = "SelecionarLivrosVenda", urlPatterns = {"/selecionar-livros"})
public class SelecionarLivrosVenda extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Armazena uma mensagem com o que ocorreu no ultimo evento
        // em uma Session HTTP
        HttpSession session = request.getSession();
        Cliente clienteVenda = (Cliente) session.getAttribute("clienteVenda");
        
        if (clienteVenda == null){
            
            //Sends the user back to the client selection
            RequestDispatcher dispatcher = request.getRequestDispatcher("/selecionar-cliente");
            dispatcher.forward(request,response);    
        }
        else{
            
            ArrayList<Livro> listaLivros = new ArrayList<Livro>();

            HashMap<Cliente,Integer> shopCart = (HashMap<Cliente, Integer>) session.getAttribute("shopCart");
            if (shopCart == null){
                shopCart = new HashMap<Cliente, Integer>();
                session.setAttribute("shopCart", shopCart);
            }
            
            String titulo =(String) request.getAttribute("titulo");
            try {
                listaLivros = DaoLivro.consultarLivros(titulo);
            } catch (SQLException ex) {
                Logger.getLogger(SelecionarLivrosVenda.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            RequestDispatcher dispatcher
               = request.getRequestDispatcher("WEB-INF/jsp/produto-venda.jsp");
            dispatcher.forward(request, response);
            
        }
    }

}
