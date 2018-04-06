package com.tadspi3null.servletProduto;

import java.io.IOException;
import java.util.ArrayList;
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
@WebServlet(name = "ServletProduto", urlPatterns = {"/consulta-produto"})
public class BuscaProduto extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
         String categoria = request.getParameter("categoria");
        String titulo = request.getParameter("titulo");
        String editora = request.getParameter("editora");
        String autor = request.getParameter("autor");
        
//        ArrayList<Produto> listaProduto = ServiceProduto.buscar(categoria,titulo,editora,autor);
//        
//        request.setAttribute("listaProduto", listaProduto);
        RequestDispatcher dispatcher = 
	    request.getRequestDispatcher("WEB-INF/jsp/consulta-produto.jsp");
        dispatcher.forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
    }
}
