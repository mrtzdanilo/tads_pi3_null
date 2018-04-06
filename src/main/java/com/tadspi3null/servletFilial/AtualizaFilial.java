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
@WebServlet(name = "AtualizaFilial", urlPatterns = {"/atualiza-filial"})
public class AtualizaFilial extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher
           = request.getRequestDispatcher("WEB-INF/jsp/atualizar-filial.jsp");
        dispatcher.forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String rua  = request.getParameter("rua");
        String bairro = request.getParameter("bairro");
        String estado = request.getParameter("estado");
        String cidade = request.getParameter("cidade");
        String numero = request.getParameter("numero");
        String complemento = request.getParameter("complemento");
        String cep = request.getParameter("cep");

//        Endereco endereco = new Endereco("rua, bairro, estado, cidade, numero, 
//                complemento, cep");

        String nomeFantasia = request.getParameter("nomeFantasia");
        String nome = request.getParameter("nome");
        String CNPJ = request.getParameter("CNPJ");
        String inscricaoEstadual = request.getParameter("inscricaoEstadual");

        String telefone = request.getParameter("telefone");
        String fax = request.getParameter("fax");
        String email = request.getParameter("email");

//
//        Filial filial = new Filial(/*endereco ,*/ nomeFantasia, nome, CNPJ, 
//                inscricaoEstadual,telefone, fax, email);
//
//        ServiceEndereco.atualizarEndereco(endereco);
//        ServiceFilial.atualizarFilial(filial);
    }
}
