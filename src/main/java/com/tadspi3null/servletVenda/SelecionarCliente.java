/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tadspi3null.servletVenda;

import com.tadspi3null.dao.DaoCliente;
import com.tadspi3null.models.Cliente;
import com.tadspi3null.servletCliente.ConsultarCliente;
import com.tadspi3null.servletCliente.DetalheCliente;
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
import javax.servlet.http.HttpSession;

/**
 *
 * @author mverissimo
 */
@WebServlet(name = "SelecionarCliente", urlPatterns = {"/selecionar-cliente"})
public class SelecionarCliente extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //Caso o cliente seja selecionado, adicionar o id do cliente na Sessão
        // e ir para a página de selecionar produtos
        String IdClienteVenda = request.getParameter("idclientevenda");
        if (IdClienteVenda != null && !"".equals(IdClienteVenda)){
            //Verifica se o Cliente existe
            Long long_id = Long.parseLong(IdClienteVenda);
        
            try {
                Cliente cliente = DaoCliente.obterPorId(long_id);
                if (cliente.getId() != null){

                    // Armazena uma mensagem com o que ocorreu no ultimo evento
                    // em uma Session HTTP
                    HttpSession session = request.getSession();
                    session.setAttribute("clienteVenda", cliente);

                    response.sendRedirect(request.getContextPath() + "/selecionar-livros");

                }

            } catch (SQLException ex) {
                Logger.getLogger(DetalheCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else{
            
            ArrayList<Cliente> listaCliente = new ArrayList<>();
        
            String nome = null;
            if (request.getParameter("nome") != null && !"".equals(
                    request.getParameter("nome"))){
                nome = request.getParameter("nome");
            }

            String cpf = null;
            if (request.getParameter("cpf") != null && !"".equals(
                    request.getParameter("cpf"))){
                cpf = request.getParameter("cpf");
            }

            try {
                listaCliente = DaoCliente.searchByNameOrCPF(nome, cpf);
                request.setAttribute("listaCliente", listaCliente);
            } catch (SQLException ex) {
                Logger.getLogger(ConsultarCliente.class.getName()).log(
                        Level.SEVERE, null, ex);
            }

            RequestDispatcher dispatcher
               = request.getRequestDispatcher("WEB-INF/jsp/cliente-venda.jsp");
            dispatcher.forward(request, response);
            
        }
    }
}
