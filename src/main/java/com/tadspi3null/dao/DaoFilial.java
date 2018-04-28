/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tadspi3null.dao;

import com.tadspi3null.connect.ConnectionUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import com.tadspi3null.models.Filial;
import java.sql.SQLException;

/**
 *
 * @author Danilo
 */
public class DaoFilial {
    public static Filial inserirFilial(Filial filial) throws SQLException{
        
        long id_endereco = DaoEndereco.inserirEndereco(filial);
        
        String query = "INSERT INTO filial (nome_fantasia, nome, cnpj, "
                + "inscricao_estadual, telefone, fax, email, id_endereco) VALUES (?,?,?,?,?,?,?,?)";
        
        try (Connection conn = ConnectionUtils.getConnection();
                PreparedStatement stmt = conn.prepareStatement(query)) {
            
            stmt.setString(1, filial.getNomeFantasia());
            stmt.setString(2, filial.getNome());
            stmt.setString(3, filial.getCnpj());
            stmt.setString(4, filial.getInscricaoEstadual());
            stmt.setString(5, filial.getTelefone());
            stmt.setString(6, filial.getFax());
            stmt.setString(7, filial.getEmail());
            stmt.setLong(8, id_endereco);
            
            stmt.executeUpdate(query);
        }
        return filial;
    }
    
     public static Filial atualizarFilial(Filial filial) throws SQLException{
        String query = "UPDATE filial SET (nome_fantasia=?, nome=?, CNPJ=?, "
                + "inscricao_estadual=?, telefone=?, fax=?, email=?)"
                + " WHERE (id=?)";
        
        try (Connection conn = ConnectionUtils.getConnection();
                PreparedStatement stmt = conn.prepareStatement(query)) {
            
            stmt.setString(1, filial.getNomeFantasia());
            stmt.setString(2, filial.getNome());
            stmt.setString(3, filial.getCnpj());
            stmt.setString(4, filial.getInscricaoEstadual());
            stmt.setString(5, filial.getTelefone());
            stmt.setString(6, filial.getFax());
            stmt.setString(7, filial.getEmail());
            stmt.setInt(8, filial.getId());
            
            stmt.executeUpdate(query);
        }
        return filial;
    }
     
    public static Filial excluirEndereco(Filial filial) throws SQLException{
        String query = "DELETE FROM filial WHERE (id=?)";
        
        try (Connection conn = ConnectionUtils.getConnection();
                PreparedStatement stmt = conn.prepareStatement(query)) {
            
            stmt.setInt(0, filial.getEndereco().getId());
            
            stmt.executeUpdate();
        }
        return filial;
    }
     
     
}
