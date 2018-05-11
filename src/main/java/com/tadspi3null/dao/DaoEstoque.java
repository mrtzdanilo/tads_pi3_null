/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tadspi3null.dao;

import com.tadspi3null.connect.ConnectionUtils;
import com.tadspi3null.dao.DaoCategoria;
import com.tadspi3null.dao.DaoFilial;
import com.tadspi3null.dao.DaoLivro;
import com.tadspi3null.models.Categoria;
import com.tadspi3null.models.Filial;
import com.tadspi3null.models.Livro;
import com.tadspi3null.models.LivroFilial;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author mverissimo
 */
public class DaoEstoque {
    
    public static void atualizar(ArrayList<LivroFilial> listaLivroFilial) throws SQLException{
        
        long id_livro = 0;
        
        String query = "INSERT INTO livro (titulo,valor,descricao,idioma,autor,"
                + "edicao,numero_paginas,isbn,editora, id_categoria) VALUES (?,?,?,?,?,?,?,?,?,?)";
        
    }
    
    public static ArrayList<LivroFilial> obterEstoque(long id_livro) throws SQLException{
        
        String query = "SELECT * FROM livro_filial where livro_filial.id_livro = ?";
        ArrayList<LivroFilial> listaLivroFilial = new ArrayList<LivroFilial>();
        
        try (Connection conn = ConnectionUtils.getConnection();
                PreparedStatement stmt = conn.prepareStatement(query)) {
                
            stmt.setLong(1, id_livro);
                
            try (ResultSet result = stmt.executeQuery()) {
                
                while (result.next()){
                    LivroFilial livroFilial = new LivroFilial();
                    Filial filial = new Filial();
                    Livro livro = new Livro();
                    
                    livro.setId(result.getLong("id_livro"));
                    filial.setId(result.getInt("id_filial"));
                    
                    livroFilial.setLivro(livro);
                    livroFilial.setFilial(filial);
                }
            }
            catch (Exception e){
                System.out.println(e);
            }
          
            }
        
        for(LivroFilial tmp: listaLivroFilial){
            tmp.setFilial(DaoFilial.consultaPorId(tmp.getFilial().getId()));
            tmp.setLivro(DaoLivro.consultaPorId(tmp.getLivro().getId()));
        }
        
        return listaLivroFilial;
        }
}
