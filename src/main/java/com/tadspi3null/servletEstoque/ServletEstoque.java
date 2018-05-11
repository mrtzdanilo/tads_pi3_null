/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tadspi3null.servletEstoque;

import com.tadspi3null.dao.DaoEstoque;
import com.tadspi3null.dao.DaoFilial;
import com.tadspi3null.dao.DaoLivro;
import com.tadspi3null.models.Categoria;
import com.tadspi3null.models.Filial;
import com.tadspi3null.models.Livro;
import com.tadspi3null.models.LivroFilial;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Enumeration;
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
            
            Livro livro = new Livro();
            livro = DaoLivro.consultaPorId(long_id);
            request.setAttribute("livro", livro);

            
            dispatcher.forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ServletEstoque.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        ArrayList<String> parameterNames = new ArrayList<String>();
        
        String id = request.getParameter("id");
        Long long_id = Long.parseLong(id);
        
        // Remove the parameter ID from the request
        request.removeAttribute("id");
        
        ArrayList<Livro> listaLivros = null;
        ArrayList<Categoria> listaCategoria = new ArrayList<Categoria>();
        
        Livro livro = new Livro();
        
        try {
            livro = DaoLivro.consultaPorId(long_id);
        } catch (SQLException ex) {
            Logger.getLogger(ServletEstoque.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Enumeration enumeration = request.getParameterNames();
        while (enumeration.hasMoreElements()) {
            String parameterName = (String) enumeration.nextElement();
            if (!"id".equals(parameterName))
                parameterNames.add(parameterName);
        }
        
        ArrayList<LivroFilial> listaLivroFilial = new ArrayList<LivroFilial>();
        for (String parameter : parameterNames) {
            
            try {
                LivroFilial livroFilial = new LivroFilial();
                livroFilial.setLivro(livro);
                Filial filial = DaoFilial.consultaPorId(Integer.parseInt(parameter));
                Integer estoque = Integer.parseInt(request.getParameter(parameter));
                livroFilial.setEstoque(estoque);
                livroFilial.setFilial(filial);
                
                listaLivroFilial.add(livroFilial);
                
            } catch (SQLException ex) {
                Logger.getLogger(ServletEstoque.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        for (LivroFilial livroFilial : listaLivroFilial){
            try {
                DaoEstoque.atualizar(livroFilial, livroFilial.getEstoque());
            } catch (SQLException ex) {
                Logger.getLogger(ServletEstoque.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        response.sendRedirect(request.getContextPath() +
                "/estoque?id=" + Long.toString(long_id));

    }
}
