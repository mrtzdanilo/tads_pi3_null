package com.tadspi3null.servletLivro;

import java.io.IOException;
import java.util.ArrayList;
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
@WebServlet(name = "AtualizarLivro", urlPatterns = {"/atualizar-livro"})
public class AtualizarLivro extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher
           = request.getRequestDispatcher("WEB-INF/jsp/autalizar-livro.jsp");
        dispatcher.forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        double valor = Double.parseDouble(request.getParameter("valor"));
        String nome = request.getParameter("nome");
        String descricao = request.getParameter("descricao");
        // implementar modo de insercao de categorias;
        
        String idioma = request.getParameter("idioma");
        String autor = request.getParameter("autor");
        String editora = request.getParameter("editora");
        String edicao = request.getParameter("edicao");
        String numeroPaginas = request.getParameter("numeroPaginas");
        String isbn = request.getParameter("isbn");
//        
//        Livro livro = new Livro(valor, nome, descricao, idioma, autor, editora,
//                edicao, numeroPaginas, isbn);
//        
//        ServiceLivro.atualizar(livro);
    }
}
