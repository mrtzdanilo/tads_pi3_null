/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tadspi3null.dao;

import com.tadspi3null.connect.ConnectionUtils;
import com.tadspi3null.models.Categoria;
import com.tadspi3null.models.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Danilo
 */
public class DaoProdutoCategoria {
    
    public static void inserirProdutoCategoria(Produto produto, Categoria categoria) throws SQLException{
        
        String query = "INSERT INTO livro_categoria (id_livro,id_categoria) VALUES (?,?)";
        
        try (Connection conn = ConnectionUtils.getConnection();
                PreparedStatement stmt = conn.prepareStatement(query)) {
            
            stmt.setLong(1, produto.getId());
            stmt.setLong(2, categoria.getId());
            
            stmt.executeUpdate();
        }
    }
    
    public static ArrayList<Categoria> obterCategorias(Produto produto) throws SQLException{
        ArrayList<Categoria> listaCategoria = new ArrayList<>();
        
        String query = " SELECT * FORM categoria INNER JOIN produto_categoria "
                + "ON  categoria.id  = livro_categoria.id_categoria"
                + " AND livro_categoria.id_livro = ?";
        
         try (Connection conn = ConnectionUtils.getConnection();
                PreparedStatement stmt = conn.prepareStatement(query)) {
            
            stmt.setLong(1, produto.getId());
            
            try (ResultSet result = stmt.executeQuery()) {
                Categoria categoria = new Categoria();
                
                categoria.setId(result.getInt("id"));
                categoria.setNome(result.getString("nome"));
                categoria.setDescricao(result.getString("descricao"));
                
                listaCategoria.add(categoria);
                
            }
         }
         return listaCategoria;
    }
}
