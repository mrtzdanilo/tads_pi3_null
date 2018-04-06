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
@WebServlet(name = "ServletProduto", urlPatterns = {"/exclui-produto"})
public class ExcluiProduto extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
//        Produto produto = ServiceProduto.buscar(request.getParameter("id_produto"));
//        ServiceFilial.excluir(produto);
//        
        
        //caso queira imprimir qual os dados do produto excluido (tem que criar o jsp
        //aqui possui apenas o endpoint ja com as informacoes da produto)
         RequestDispatcher dispatcher = 
	    request.getRequestDispatcher("WEB-INF/jsp/produto-excluido");
        dispatcher.forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
    }
}