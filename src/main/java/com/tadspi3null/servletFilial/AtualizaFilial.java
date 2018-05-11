package com.tadspi3null.servletFilial;


import com.tadspi3null.dao.DaoFilial;
import com.tadspi3null.models.Endereco;
import com.tadspi3null.models.Filial;
import java.io.IOException;
import java.sql.SQLException;
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
@WebServlet(name = "AtualizaFilial", urlPatterns = {"/atualizar-filial"})
public class AtualizaFilial extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Endereco endereco = new Endereco();
        
        endereco.setId(Integer.parseInt(request.getParameter("id_endereco")));
        endereco.setRua(request.getParameter("rua"));
        endereco.setBairro(request.getParameter("bairro"));
        endereco.setEstado(request.getParameter("estado"));
        endereco.setCidade(request.getParameter("cidade"));
        endereco.setNumero(request.getParameter("numero"));
        endereco.setCep(request.getParameter("cep"));

        Filial filial = new Filial();
        filial.setId(Integer.parseInt(request.getParameter("id_filial")));
        filial.setNomeFantasia(request.getParameter("nomeFantasia"));
        filial.setNome(request.getParameter("nome"));
        filial.setCnpj(request.getParameter("cnpj"));
        filial.setInscricaoEstadual(request.getParameter("inscricaoEstadual"));

        filial.setTelefone(request.getParameter("telefone"));
        filial.setFax(request.getParameter("fax"));
        filial.setEmail(request.getParameter("email"));
        filial.setEndereco(endereco);
        try {
            DaoFilial.atualizarFilial(filial);
            request.setAttribute("filial", filial);
            request.setAttribute("endereco", endereco);
            response.sendRedirect(request.getContextPath() +
                "/detalhe-filial");
        } catch (SQLException ex) {
            Logger.getLogger(AtualizaFilial.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
