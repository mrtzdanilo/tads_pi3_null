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
@WebServlet(name = "AtualizarLivro", urlPatterns = {"/atualizar-livro"})
public class AtualizarLivro extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String message = "";
        
        String id = request.getParameter("id_livro");
        Long long_id = Long.parseLong(id);
        
        try {
            double valor = Double.parseDouble(request.getParameter("valor"));
            String titulo = request.getParameter("titulo");
            String descricao = request.getParameter("descricao");
            // implementar modo de insercao de categorias;
        
            String idioma = request.getParameter("idioma");
            String autor = request.getParameter("autor");
            String editora = request.getParameter("editora");
            String edicao = request.getParameter("edicao");
            String numeroPaginas = request.getParameter("numeroPaginas");
            String isbn = request.getParameter("isbn");
            Long idCategoria = Long.parseLong(request.getParameter("categoria"));
        
            Categoria categoria = new Categoria();
        
            categoria = DaoCategoria.obterCategoria(idCategoria);
        
            Livro livro = new Livro(titulo, idioma, autor, editora, edicao, 
                numeroPaginas, isbn, valor, descricao, categoria);
            
            livro.setId(long_id);
          
            DaoLivro.atualizarLivro(livro);
            
            message = "Livro atualizado com sucesso";
     
        } catch (Exception ex) {
            Logger.getLogger(DetalheLivro.class.getName()).log(Level.SEVERE,
                                                               null, ex);
            message = "Falha ao atualizar informações";
        }
        
        // Armazena uma mensagem com o que ocorreu no ultimo evento
        // em uma Session HTTP
        HttpSession session = request.getSession();
        session.setAttribute("message", message);
        
        // Redireciona para a mesma página de detalhes do livro com os
        // dados atualizados
        response.sendRedirect(request.getContextPath() +
                "/detalhe-livro?id=" + Long.toString(long_id));
    }
}
