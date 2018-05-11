/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tadspi3null.servletUsuario;

import com.tadspi3null.dao.DaoFuncao;
import com.tadspi3null.models.Funcao;
import com.tadspi3null.models.Usuario;
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
@WebServlet(name = "CadastrarUsuario", urlPatterns = {"/cadastrar-usuario"})
public class CadastrarUsuario extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher
           = request.getRequestDispatcher("WEB-INF/jsp/cadastrar-usuario.jsp");
        
        try {
            ArrayList<Funcao> listaFuncao = DaoFuncao.obterListaFuncao();
            request.setAttribute("listaFuncao", listaFuncao);
            dispatcher.forward(request, response);
            
            
        } catch (SQLException ex) {
            Logger.getLogger(CadastrarUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Usuario usuario = new Usuario();
        Funcao funcao = new Funcao();
        
        usuario.setNome(request.getParameter("nome"));
        usuario.setNome(request.getParameter("sexo"));
        usuario.setNome(request.getParameter("telefone"));
        usuario.setNome(request.getParameter("sobreNome"));
        Long idFuncao = Long.parseLong(request.getParameter("idFuncao"));
        
        try {
            funcao = DaoFuncao.obterFuncaoPOrId(idFuncao);
        } catch (SQLException ex) {
            Logger.getLogger(CadastrarUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        usuario.setFuncao(funcao);
        
        RequestDispatcher dispatcher
           = request.getRequestDispatcher("WEB-INF/jsp/cadastrar-usuario.jsp");
        dispatcher.forward(request, response);
    }
}
