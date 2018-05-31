/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tadspi3null.servletVenda;

import com.tadspi3null.dao.DaoLivro;
import com.tadspi3null.models.Livro;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@WebServlet(name = "RemoverDoCarrinho", urlPatterns = {"/remover-do-carrinho"})
public class RemoverDoCarrinho extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Armazena uma mensagem com o que ocorreu no ultimo evento
        // em uma Session HTTP
        HttpSession session = request.getSession();
        
        //get the shop cart
        HashMap<Livro, Integer> shopCart = (HashMap<Livro, Integer>) session.getAttribute("shopCart");
        
        
        String livroIdString = request.getParameter("selectedItemId");
        Long livroIdLong = Long.parseLong(livroIdString);

        try {
            Livro livro = DaoLivro.consultaPorId(livroIdLong);
            shopCart.remove(livro);
            
            session.setAttribute("shopCart", shopCart);   
        } catch (SQLException ex) {
            Logger.getLogger(AdicionarAoCarrinho.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        response.sendRedirect(request.getContextPath() + "/selecionar-livros");
    }
}
