package com.tadspi3null.servletFilial;

import com.tadspi3null.dao.DaoFilial;
import com.tadspi3null.models.Filial;
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
@WebServlet(name = "ConsultarFilial", urlPatterns = {"/consultar-filial"})
public class ConsultarFilial extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String nome = request.getParameter("nome");
        String nomeFantasia = request.getParameter("nomeFantasia");
        String cnpj = request.getParameter("cnpj");
        
        ArrayList<Filial> listaFilial = new ArrayList<>();
        try {
            listaFilial = DaoFilial.consultaFilial(nomeFantasia);
        } catch (SQLException ex) {
            Logger.getLogger(ConsultarFilial.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        request.setAttribute("listaFilial", listaFilial);
        RequestDispatcher dispatcher = 
	    request.getRequestDispatcher("WEB-INF/jsp/consultar-filial.jsp");
        dispatcher.forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     
    }
}

