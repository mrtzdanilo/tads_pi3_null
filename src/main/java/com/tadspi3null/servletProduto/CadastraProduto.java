package com.tadspi3null.servletProduto;

import com.tadspi3null.dao.DaoCategoria;
import com.tadspi3null.dao.DaoProduto;
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

/**
 *
 * @author Danilo
 */
@WebServlet(name = "CadastraProduto", urlPatterns = {"/cadastro-produto"})
public class CadastraProduto extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher
           = request.getRequestDispatcher("WEB-INF/cadastro-produto.jsp");
        dispatcher.forward(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        double valor = 0.0;
        String titulo = request.getParameter("titulo");
        String descricao = request.getParameter("descricao");
        // implementar modo de insercao de categorias;
        
        String idioma = request.getParameter("idioma");
        String autor = request.getParameter("autor");
        String editora = request.getParameter("editora");
        String edicao = request.getParameter("edicao");
        String numeroPaginas = request.getParameter("numeroPaginas");
        String isbn = request.getParameter("isbn");
        
        Categoria categoria = new Categoria();
        
        try {
           categoria = DaoCategoria.obterCategoria(1L);
        } catch (SQLException ex) {
            Logger.getLogger(CadastraProduto.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Livro livro = new Livro(titulo, idioma, autor, editora, edicao, 
                numeroPaginas, isbn, valor, descricao);
        
        livro.addCategoria(categoria);
        
        
        try {
            DaoProduto.inserirLivro(livro);
        } catch (SQLException ex) {
            Logger.getLogger(CadastraProduto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}