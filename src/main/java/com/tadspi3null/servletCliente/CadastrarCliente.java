/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tadspi3null.servletCliente;

import com.tadspi3null.dao.DaoCliente;
import com.tadspi3null.models.Cliente;
import com.tadspi3null.models.Endereco;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Danilo
 */
@WebServlet(name = "CadastrarCliente", urlPatterns = {"/cadastrar-cliente"})
public class CadastrarCliente extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Cliente cliente = new Cliente();
        Endereco endereco = new Endereco();
        
        cliente.setNome(request.getParameter("nome"));
        cliente.setSobrenome(request.getParameter("sobrenome"));
        cliente.setCpf(request.getParameter("cpf"));
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            cliente.setDtNascimento(sdf.parse(request.getParameter("dtNascimento")));
        } catch (ParseException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
        
        endereco.setRua(request.getParameter("rua"));
        endereco.setBairro(request.getParameter("bairro"));
        endereco.setCidade(request.getParameter("cidade"));
        endereco.setEstado(request.getParameter("Estado"));
        endereco.setNumero(request.getParameter("numero"));
        endereco.setCep(request.getParameter("cep"));
        
        cliente.setEndereco(endereco);
        
        try {
            DaoCliente.inserirCliente(cliente);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
    }
}
