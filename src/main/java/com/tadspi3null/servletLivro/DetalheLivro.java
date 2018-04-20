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
@WebServlet(name = "DetalheLivro", urlPatterns = {"/detalhe-livro"})
public class DetalheLivro extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String id = request.getParameter("id");
        Long long_id = Long.parseLong(id);
        
        
        ArrayList<Livro> listaLivros = null;
        try {
            Livro livro = DaoLivro.consultaPorId(id);
            
            request.setAttribute("livro", livro);
            
        } catch (SQLException ex) {
            Logger.getLogger(DetalheLivro.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        RequestDispatcher dispatcher = 
	    request.getRequestDispatcher("WEB-INF/jsp/detalhe-livro.jsp");
        dispatcher.forward(request, response);
    }
}
