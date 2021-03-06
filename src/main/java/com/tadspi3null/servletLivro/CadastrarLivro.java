package com.tadspi3null.servletLivro;

import com.tadspi3null.dao.DaoCategoria;
import com.tadspi3null.dao.DaoLivro;
import com.tadspi3null.models.Categoria;
import com.tadspi3null.models.Livro;
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
 * @author Danilo
 */
@WebServlet(name = "CadastrarLivro", urlPatterns = {"/cadastrar-livro"})
public class CadastrarLivro extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher
           = request.getRequestDispatcher("WEB-INF/jsp/cadastrar-livro.jsp");
        
        ArrayList<Categoria> listaCategoria = null;
        try {
            listaCategoria = DaoCategoria.getCategorias();
            
            request.setAttribute("categorias", listaCategoria);
            
            dispatcher.forward(request, response);
            
        } catch (SQLException ex) {
            Logger.getLogger(DetalheLivro.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Double valor = null;
        try{
            valor = Double.parseDouble(request.getParameter("valor"));
        } catch(Exception e){      
            e.printStackTrace();
        }
        String titulo = request.getParameter("titulo");
        String descricao = request.getParameter("descricao");
        String idioma = request.getParameter("idioma");
        String autor = request.getParameter("autor");
        String editora = request.getParameter("editora");
        String edicao = request.getParameter("edicao");
        String numeroPaginas = request.getParameter("numeroPaginas");
        String isbn = request.getParameter("isbn");
        Long idCategoria = Long.parseLong(request.getParameter("categoria"));
        
        Categoria categoria = new Categoria();
        
        String message = "";
        try {
           categoria = DaoCategoria.obterCategoria(idCategoria);
        } catch (SQLException ex) {
            Logger.getLogger(CadastrarLivro.class.getName()).log(Level.SEVERE, null, ex);
            message = "Falha ao localizar categoria selecionada";
        }
        
        Livro livro = new Livro(titulo, idioma, autor, editora, edicao, 
                numeroPaginas, isbn, valor, descricao, categoria);
        try {
            DaoLivro.inserirLivro(livro);
            
            message = "Livro cadastrado com sucesso";
        } catch (SQLException ex) {
            Logger.getLogger(CadastrarLivro.class.getName()).log(Level.SEVERE, null, ex);
            message = "Falha ao cadastrar livro";
        }
        
        // Armazena uma mensagem com o que ocorreu no ultimo evento
        // em uma Session HTTP
        HttpSession session = request.getSession();
        session.setAttribute("message", message);
        
        response.sendRedirect(request.getContextPath() + "/cadastrar-livro");
    }
}