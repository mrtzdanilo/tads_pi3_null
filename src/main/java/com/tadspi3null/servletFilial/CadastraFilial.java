package com.tadspi3null.servletFilial;

import com.tadspi3null.dao.DaoEndereco;
import com.tadspi3null.dao.DaoFilial;
import com.tadspi3null.models.Endereco;
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
@WebServlet(name = "ServletFilial", urlPatterns = {"/cadastrar-filial"})
public class CadastraFilial extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher
           = request.getRequestDispatcher("WEB-INF/jsp/cadastrar-filial.jsp");
        dispatcher.forward(request, response);
        
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Endereco endereco = new Endereco();
        
        endereco.setRua(request.getParameter("rua"));
        endereco.setBairro(request.getParameter("bairro"));
        endereco.setEstado(request.getParameter("estado"));
        endereco.setCidade(request.getParameter("cidade"));
        endereco.setNumero(request.getParameter("numero"));
        endereco.setCep(request.getParameter("cep"));


        String nomeFantasia = request.getParameter("nomeFantasia");
        String nome = request.getParameter("nome");
        String CNPJ = request.getParameter("cnpj");
        String inscricaoEstadual = request.getParameter("inscricaoEstadual");

        String telefone = request.getParameter("telefone");
        String fax = request.getParameter("fax");
        String email = request.getParameter("email");


        Filial filial = new Filial(endereco ,nomeFantasia, nome, CNPJ, 
                inscricaoEstadual,telefone, fax, email);

        try {
            DaoEndereco.inserirEndereco(endereco);
        } catch (SQLException ex) {
            Logger.getLogger(CadastraFilial.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            DaoFilial.inserirFilial(filial);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
        
        RequestDispatcher dispatcher
           = request.getRequestDispatcher("WEB-INF/jsp/cadastrar-filial.jsp");
        dispatcher.forward(request, response);
    }
}