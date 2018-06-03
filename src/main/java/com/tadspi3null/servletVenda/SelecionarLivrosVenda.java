/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tadspi3null.servletVenda;

import com.tadspi3null.dao.DaoCliente;
import com.tadspi3null.dao.DaoEstoque;
import com.tadspi3null.dao.DaoFilial;
import com.tadspi3null.dao.DaoLivro;
import com.tadspi3null.dao.DaoUsuario;
import com.tadspi3null.dao.DaoVenda;
import com.tadspi3null.models.Cliente;
import com.tadspi3null.models.Filial;
import com.tadspi3null.models.ItemVenda;
import com.tadspi3null.models.Livro;
import com.tadspi3null.models.LivroFilial;
import com.tadspi3null.models.Usuario;
import com.tadspi3null.models.Venda;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
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
@WebServlet(name = "SelecionarLivrosVenda", urlPatterns = {"/selecionar-livros"})
public class SelecionarLivrosVenda extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Armazena uma mensagem com o que ocorreu no ultimo evento
        // em uma Session HTTP
        HttpSession session = request.getSession();
        Cliente clienteVenda = (Cliente) session.getAttribute("clienteVenda");
        
        // TODO: Obter filial pelo usuario na sessão, e não fixo
        Integer id_filial = Integer.parseInt("1");

        
        if (clienteVenda == null){          
            //Sends the user back to the client selection
            RequestDispatcher dispatcher = request.getRequestDispatcher("/selecionar-cliente");
            dispatcher.forward(request,response);    
        }
        else{
            
            ArrayList<Livro> listaLivros = new ArrayList<Livro>();

            HashMap<Livro, Integer> shopCart = (HashMap<Livro, Integer>) session.getAttribute("shopCart");
            if (shopCart == null){
                shopCart = new HashMap<Livro, Integer>();
                session.setAttribute("shopCart", shopCart);
            }
                     
            String titulo =(String) request.getParameter("titulo");
            try {
                listaLivros = DaoLivro.consultarLivros(titulo);
            } catch (SQLException ex) {
                Logger.getLogger(SelecionarLivrosVenda.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            HashMap<Long, Integer> estoque = new HashMap<Long, Integer>();
            //Obtem o estoque para cada livro
            for (Livro livro: listaLivros){
                try {
                    LivroFilial livroFilial = DaoEstoque.obterPorId(
                            livro.getId(), id_filial);
                    estoque.put(livroFilial.getLivro().getId(),
                                livroFilial.getEstoque());
                    
                } catch (SQLException ex) {
                    Logger.getLogger(SelecionarLivrosVenda.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            Double total = 0.0;
            //Calculate the total
            for(Map.Entry<Livro, Integer> entry : shopCart.entrySet()) {
                Livro key = entry.getKey();
                Integer value = entry.getValue();

                total = total + (key.getValor() * value);
            }
            
            request.setAttribute("total", total);
            request.setAttribute("listaLivros", listaLivros);
            request.setAttribute("estoque", estoque);
            
            RequestDispatcher dispatcher
               = request.getRequestDispatcher("WEB-INF/jsp/produto-venda.jsp");
            dispatcher.forward(request, response);
            
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        /* Neste método a venda é realizada */
        
        // Armazena uma mensagem com o que ocorreu no ultimo evento
        // em uma Session HTTP
        HttpSession session = request.getSession();
        Cliente cliente = (Cliente) session.getAttribute("clienteVenda");
        HashMap<Livro, Integer> shopCart = (HashMap<Livro, Integer>) session.getAttribute("shopCart");
        boolean cancelarVenda = false;
        
        
        
        if (cliente == null){
            //Sends the user back to the client selection
            RequestDispatcher dispatcher = request.getRequestDispatcher("/selecionar-cliente");
            dispatcher.forward(request,response);    
        }
        else if (shopCart.isEmpty()){
            //TODO Adicionar uma mensagem para o usuario.
            RequestDispatcher dispatcher = request.getRequestDispatcher("/selecionar-livros");
            dispatcher.forward(request,response);
            
        }
        else{
            try {
                Usuario usuario = DaoUsuario.obterUsuarioPorId(Long.parseLong("1"));
                Filial filial = DaoFilial.consultaPorId(1);
                Venda venda = new Venda();
                
                venda.setCliente(cliente);
                venda.setUsuario(usuario);
                venda.setFilial(filial);

                //Cria uma lista de itens venda para a venda
                ArrayList<ItemVenda> listaItemVenda = new ArrayList<ItemVenda>();
                                
                for(Map.Entry<Livro, Integer> entry : shopCart.entrySet()) {
                    Livro livro = entry.getKey();
                    Integer quantidade = entry.getValue();
                    
                    LivroFilial livroFilial = DaoEstoque.obterPorId(livro.getId(), filial.getId());
                    
                    if (quantidade > livroFilial.getEstoque()){

                        cancelarVenda = true;
                        break;
                        
                    }
                    
                    ItemVenda itemVenda = new ItemVenda();
                    
                    itemVenda.setQuantidade(quantidade);
                    itemVenda.setValorUnitario(livro.getValor());
                    itemVenda.setLivroFilial(livroFilial);
                    
                    listaItemVenda.add(itemVenda);
                }
                
                //Check if we have enough items available to sell
                if (cancelarVenda){
                    String msg = "A quantidade solicitada não "
                                + "está disponível em estoque, atualize e tente"
                                + " novamente";
                    session.setAttribute("msg", msg);
                    
                    response.sendRedirect(request.getContextPath()
                            + "/selecionar-livros");
                }
                else{
                // Finaliza a realização da venda    
                    venda.setListaItemVenda(listaItemVenda);
                    DaoVenda.inserirVenda(venda);
                    
                    //Clean the old attributes not needed
                    session.removeAttribute("shopCart");
                    session.removeAttribute("clienteVenda");
                    session.removeAttribute("msg");
                   
                    response.sendRedirect(request.getContextPath()
                            + "/confirmacao-venda?idVenda="+venda.getId());
                }

            } catch (SQLException ex) {
                Logger.getLogger(SelecionarLivrosVenda.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        }
}
