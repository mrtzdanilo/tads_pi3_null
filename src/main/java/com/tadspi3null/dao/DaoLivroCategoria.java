/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tadspi3null.dao;

import com.tadspi3null.connect.ConnectionUtils;
import com.tadspi3null.models.Categoria;
import com.tadspi3null.models.Livro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Danilo
 */
public class DaoLivroCategoria {
    
    public static void inserirLivroCategoria(Livro livro, Categoria categoria) throws SQLException{
        
        String query = "INSERT INTO livro_categoria (id_livro,id_categoria) VALUES (?,?)";
        
        try (Connection conn = ConnectionUtils.getConnection();
                PreparedStatement stmt = conn.prepareStatement(query)) {
            
            stmt.setLong(1, livro.getId());
            stmt.setLong(2, categoria.getId());
            
            stmt.executeUpdate();
        }
    }
    
    public static ArrayList<Categoria> obterCategorias(Livro livro) throws SQLException{
        ArrayList<Categoria> listaCategoria = new ArrayList<>();
        
        String query = " SELECT * FORM categoria INNER JOIN livro_categoria "
                + "ON  categoria.id  = livro_categoria.id_categoria"
                + " AND livro_categoria.id_livro = ?";
        
         try (Connection conn = ConnectionUtils.getConnection();
                PreparedStatement stmt = conn.prepareStatement(query)) {
            
            stmt.setLong(1, livro.getId());
            
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
