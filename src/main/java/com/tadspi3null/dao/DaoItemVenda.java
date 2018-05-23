/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tadspi3null.dao;

import com.tadspi3null.connect.ConnectionUtils;
import com.tadspi3null.models.ItemVenda;
import com.tadspi3null.models.Livro;
import com.tadspi3null.models.LivroFilial;
import com.tadspi3null.models.Venda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Danilo
 */
public class DaoItemVenda {
    
    
    public static void inserirItemVenda(Long venda_id, ItemVenda itemVenda) throws SQLException{
        
        String query = "INSERT INTO item_venda (id_venda, id_livro, quantidade, valor_unitario) VALUES (?,?,?,?)";
        
        try (Connection conn = ConnectionUtils.getConnection();
                PreparedStatement stmt = conn.prepareStatement(query)) {
            
            stmt.setLong(1, venda_id);
            stmt.setLong(2, itemVenda.getLivroFilial().getLivro().getId());
            stmt.setInt(3, itemVenda.getQuantidade());
            stmt.setDouble(4, itemVenda.getValorUnitario());
            
            stmt.executeUpdate();
            
            }
    }

    static ArrayList<ItemVenda> obterListaPorId(Venda venda) throws SQLException {
        ArrayList<ItemVenda> listaItemVenda = new ArrayList<>();
        
        String query = "SELECT * FROM item_venda WHERE id_venda = ?";
        
        try (Connection conn = ConnectionUtils.getConnection();
                PreparedStatement stmt = conn.prepareStatement(query)) {
            
            stmt.setLong(1, venda.getId());
            
            try (ResultSet result = stmt.executeQuery()) {
                while(result.next()){
                    ItemVenda itemVenda = new ItemVenda();
                    Livro livro = new Livro();
                    LivroFilial livroFilial = new LivroFilial();
                    itemVenda.setLivroFilial(livroFilial);
                    
                    itemVenda.setId(result.getLong("item_venda_id"));
                    
                    livro.setId(result.getLong("id_livro"));
                    itemVenda.getLivroFilial().setLivro(livro);
                    
                    itemVenda.setQuantidade(result.getInt("quantidade"));
                    itemVenda.setValorUnitario(result.getDouble("valor_unitario"));
                    
                    listaItemVenda.add(itemVenda);
                }
            }
            
        }
        
        //preenche todos os itens de venda seus respectivos livros
        for(ItemVenda itemVenda: listaItemVenda){
            itemVenda.getLivroFilial().setLivro(DaoLivro.consultaPorId(itemVenda.getLivroFilial().getLivro().getId()));
            itemVenda.setLivroFilial(DaoEstoque.obterPorId(itemVenda.getLivroFilial().getLivro().getId(), 
                    venda.getFilial().getId()));
        }
        
        return listaItemVenda;
    }
            
    
    
}
