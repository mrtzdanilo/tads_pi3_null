package com.tadspi3null.servletFilial;

import com.tadspi3null.dao.DaoFilial;
import com.tadspi3null.models.Filial;
import java.io.IOException;
import java.sql.SQLException;
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
@WebServlet(name = "ExcluiFilial", urlPatterns = {"/excluir-filial"})
public class ExcluiFilial extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Filial filial = null;
        try {
            filial = DaoFilial.consultaPorId(Integer.parseInt(request.getParameter("id_filial")));
        } catch (SQLException ex) {
            Logger.getLogger(ExcluiFilial.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            DaoFilial.excluirFilial(filial);
        } catch (SQLException ex) {
            Logger.getLogger(ExcluiFilial.class.getName()).log(Level.SEVERE, null, ex);
        }
        
         RequestDispatcher dispatcher = 
	    request.getRequestDispatcher("WEB-INF/jsp/consultar-filial.jsp");
        dispatcher.forward(request, response);
        
    }

}
