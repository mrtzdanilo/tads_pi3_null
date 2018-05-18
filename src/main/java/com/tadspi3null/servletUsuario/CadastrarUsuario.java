/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tadspi3null.servletUsuario;

import com.tadspi3null.dao.DaoFuncao;
import com.tadspi3null.dao.DaoUsuario;
import com.tadspi3null.models.Funcao;
import com.tadspi3null.models.Usuario;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
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
 * @author Alexandre
 */
@WebServlet(name = "CadastrarUsuario", urlPatterns = {"/cadastrar-usuario"})
public class CadastrarUsuario extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // valor da funcao é no DOGET
        try {
            HttpSession sessao = request.getSession();
            ArrayList<Funcao> listaFuncao = DaoFuncao.obterListaFuncao();
            request.setAttribute("listaFuncao2", listaFuncao);
            sessao.setAttribute("listaFuncao", listaFuncao);

        } catch (SQLException ex) {
            Logger.getLogger(CadastrarUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        RequestDispatcher dispatcher
                = request.getRequestDispatcher("WEB-INF/jsp/cadastrar-usuario.jsp");
        dispatcher.forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Usuario usuario = new Usuario();

        HttpSession sessao = request.getSession();

        usuario.setNome(request.getParameter("nome"));
        usuario.setSexo(request.getParameter("sexo"));
        usuario.setTelefone(request.getParameter("telefone"));
        usuario.setSobrenome(request.getParameter("sobrenome"));
        usuario.setFuncaoNome(request.getParameter("funcao"));

        try {
            //criando objeto funcao por nome
            Date data = Auxiliar.InputDateToUtilDate(request.getParameter("dt_admissao"));
            usuario.setDtAdmissao(data);
            Funcao funcao = DaoFuncao.obterFuncaoPorNome(usuario.getFuncaoNome());
            usuario.setFuncao(funcao);
            DaoUsuario.inserirUsuario(usuario);

            // funcao = DaoFuncao.obterFuncaoPOrId(idFuncao);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (ParseException ex) {
            Logger.getLogger(CadastrarUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }

        RequestDispatcher dispatcher
                = request.getRequestDispatcher("WEB-INF/jsp/cadastrar-usuario.jsp");
        dispatcher.forward(request, response);
    }

}
