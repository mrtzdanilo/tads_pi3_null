/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tadspi3null.servletUsuario;

import com.tadspi3null.dao.DaoUsuario;
import com.tadspi3null.models.Usuario;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Alexadre
 */
@WebServlet(name = "ConsultarUsuario", urlPatterns = {"/consultar-usuario"})
public class ConsultarUsuario extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nome = request.getParameter("nome");
        String sobrenome = request.getParameter("sobrenome");
        String telefone = request.getParameter("telefone");

        List<Usuario> listUsuario = new ArrayList<>();
        if (nome != null) {
            try {
                listUsuario = DaoUsuario.obterUsuarioPorNome(nome);
                request.setAttribute("listUsuario", listUsuario);
            } catch (SQLException e) {
            }
            
        }
        RequestDispatcher dispatcher
                = request.getRequestDispatcher("WEB-INF/jsp/consultar-usuario.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

}
