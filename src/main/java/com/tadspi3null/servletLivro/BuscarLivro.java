package com.tadspi3null.servletLivro;

import com.tadspi3null.dao.DaoCategoria;
import com.tadspi3null.dao.DaoLivro;
import com.tadspi3null.models.Categoria;
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
@WebServlet(name = "BuscarLivro", urlPatterns = {"/consultar-livro"})
public class BuscarLivro extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        ArrayList<Categoria> listaCategoria = new ArrayList<Categoria>();
        
        String titulo = "";
        if (request.getParameter("titulo") != null){
            titulo = request.getParameter("titulo");
        }
        
        String categoria = request.getParameter("categoria");
        String editora = request.getParameter("editora");
        String autor = request.getParameter("autor");
        
        
        ArrayList<Livro> listaLivros = null;
        try {
            listaLivros = DaoLivro.consutarLivros(titulo);
            
            listaCategoria = DaoCategoria.getCategorias();
            request.setAttribute("categorias", listaCategoria);
            
            request.setAttribute("listaLivros", listaLivros);
            
        } catch (SQLException ex) {
            Logger.getLogger(BuscarLivro.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        RequestDispatcher dispatcher = 
	    request.getRequestDispatcher("WEB-INF/jsp/consultar-livro.jsp");
        dispatcher.forward(request, response);
    }
}
