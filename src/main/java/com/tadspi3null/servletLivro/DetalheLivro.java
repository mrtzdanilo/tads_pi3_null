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
@WebServlet(name = "DetalheLivro", urlPatterns = {"/detalhe-livro"})
public class DetalheLivro extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String id = request.getParameter("id");
        Long long_id = Long.parseLong(id);
        
        
        ArrayList<Livro> listaLivros = null;
        ArrayList<Categoria> listaCategoria = new ArrayList<Categoria>();
        
        try {
            Livro livro = DaoLivro.consultaPorId(long_id);
            
            request.setAttribute("livro", livro);
            
            listaCategoria = DaoCategoria.getCategorias();
            request.setAttribute("categorias", listaCategoria);
            
            // Codigo improvisado
            // Enviar todos os idiomas e o idioma persistente neste livro                
            ArrayList<String> listaIdioma = new ArrayList();
            listaIdioma.add("Portuges");
            listaIdioma.add("Inglês");
            listaIdioma.add("Espanhol");
            
            request.setAttribute("idiomas", listaIdioma);
            
        } catch (SQLException ex) {
            Logger.getLogger(DetalheLivro.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        RequestDispatcher dispatcher = 
	    request.getRequestDispatcher("WEB-INF/jsp/detalhe-livro.jsp");
        dispatcher.forward(request, response);
    }
}
