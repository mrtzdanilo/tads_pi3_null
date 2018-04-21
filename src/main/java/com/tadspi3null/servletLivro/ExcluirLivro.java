package com.tadspi3null.servletLivro;

import com.tadspi3null.dao.DaoLivro;
import com.tadspi3null.models.Livro;

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
@WebServlet(name = "ExcluirLivro", urlPatterns = {"/excluir-livro"})
public class ExcluirLivro extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String id_livro = request.getParameter("id_livro");
        
        try {
            //Check if the book exist
            Livro livro = DaoLivro.consultaPorId(id_livro);
            
            if (livro != null){
                DaoLivro.excluirLivro(livro);
            }
            else{
                System.out.println("Book not found when excluding");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ExcluirLivro.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }
}