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
@WebServlet(name = "ExcluiFilial", urlPatterns = {"/exclui-filial"})
public class ExcluiFilial extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        
//        Filial filial = ServiceFilial.buscar(request.getParameter("id_filial"));
//        ServiceFilial.excluir(filial);
//        
        
        //caso queira imprimir qual os dados da filial exluida (tem que criar o jsp
        //aqui possui apenas o endpoint ja com as informacoes da filial)
//         RequestDispatcher dispatcher = 
//	    request.getRequestDispatcher("WEB-INF/jsp/filial-excluida.jsp");
//        dispatcher.forward(request, response);
        
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     
    }
}
