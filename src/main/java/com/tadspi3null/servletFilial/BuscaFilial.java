package com.tadspi3null.servletFilial;

import java.io.IOException;
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
@WebServlet(name = "ServletFilial", urlPatterns = {"/busca-filial"})
public class BuscaFilial extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String nome = request.getParameter("nome");
        String nomeFantasia = request.getParameter("nomeFantasia");
        String CNPJ = request.getParameter("CNPJ");
//        
//        ArrayList<Filial> listaFilial = ServiceFilial.buscar(nome ,nomeFantasia, CNPJ);
//        
//        request.setAttribute("listaProduto", listaFilial);
        RequestDispatcher dispatcher = 
	    request.getRequestDispatcher("WEB-INF/jsp/consulta-filial.jsp");
        dispatcher.forward(request, response);
        
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     
    }
}

