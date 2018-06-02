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
@WebServlet(name = "AdicionarAoCarrinho", urlPatterns = {"/adicionar-ao-carrinho"})
public class AdicionarAoCarrinho extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Armazena uma mensagem com o que ocorreu no ultimo evento
        // em uma Session HTTP
        HttpSession session = request.getSession();
        
        //get the shop cart
        HashMap<Livro, Integer> shopCart = (HashMap<Livro, Integer>) session.getAttribute("shopCart");
        
        
        String livroIdString = request.getParameter("selectedItemId");
        
        if (livroIdString == null || "".equals(livroIdString)){
            String msg = "Selecione um item para adicionar ao carrinho com uma"
                    + " quantidade valida";
            
            session.setAttribute("msg", msg);
        }
        else{
            Integer quantidade = Integer.parseInt(request.getParameter(livroIdString));
            Long livroIdLong = Long.parseLong(livroIdString); 
            
            if (quantidade > 0){
                try {
                    Livro livro = DaoLivro.consultaPorId(livroIdLong);
                    //Check if this books is already on the shop cart
                    Integer quantidadeNoCarrinho = shopCart.get(livro);
                    if (quantidadeNoCarrinho == null){
                        //Adiciona o item pela primeira vez no carrinho com a quantidade
                        //selecionada
                        shopCart.put(livro, quantidade);
                    }
                    else{
                        //Somente adiciona mais quantidade ao item selecionado
                        shopCart.put(livro, shopCart.get(livro) + quantidade);  
                    }
                    session.setAttribute("shopCart", shopCart);   

                    String msg = "Item adicionado ao carrinho";

                    session.setAttribute("msg", msg);
                } 
                catch (SQLException ex) {
                    Logger.getLogger(AdicionarAoCarrinho.class.getName()).log(Level.SEVERE, null, ex);
                }             
            }
            else{
                String msg = "A quantidade selecionada deve ser maior que 0";
            
                session.setAttribute("msg", msg);
            }
        }
        response.sendRedirect(request.getContextPath() + "/selecionar-livros");
    }
}
