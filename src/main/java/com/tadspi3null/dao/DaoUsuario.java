/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tadspi3null.dao;

import com.tadspi3null.connect.ConnectionUtils;
import com.tadspi3null.models.Funcao;
import com.tadspi3null.models.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Danilo
 */
public class DaoUsuario {
    
    public static void inserirUsuario(Usuario usuario) throws SQLException{
        
        String query = "INSERT INTO usuario (nome, sobre_nome, sexo, telefone, dt_admissao, id_funcao) VALUES (?,?,?,?,?)";
        
        try (Connection conn = ConnectionUtils.getConnection();
                PreparedStatement stmt = conn.prepareStatement(query)) {
            
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getSobrenome());
            stmt.setString(3, usuario.getSexo());
            stmt.setLong(4, usuario.getFuncao().getId());
            stmt.setString(5, usuario.getTelefone());
            java.sql.Date data = new java.sql.Date(usuario.getDtAdmissao().getTime());
            stmt.setDate(6, data);
            
            stmt.executeUpdate();
        }
    }
    
    public static Usuario obterUsuarioPorId(Long id) throws SQLException{
        Usuario usuario = new Usuario();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
        
        String query = "SELECT * FROM usuario WHERE usuario.id = ? AND removido = false";
        Funcao funcao = new Funcao();
        try (Connection conn = ConnectionUtils.getConnection();
                PreparedStatement stmt = conn.prepareStatement(query)) {
            
            stmt.setLong(1, id);
            
            try (ResultSet result = stmt.executeQuery()) {
                
                while(result.next()){
                    
                    usuario.setId(result.getLong("id"));
                    usuario.setNome(result.getString("nome"));
                    usuario.setSobrenome(result.getString("sobreNome"));
                    funcao.setId(result.getLong("id_funcao"));
                    usuario.setSexo(result.getString("sexo"));
                    usuario.setTelefone(result.getString("telefone"));
                    Date dtAdmissao = result.getDate("dt_admissao");
                    usuario.setDtAdmissao(dtAdmissao);
                }
            }
        }
        usuario.setFuncao(DaoFuncao.obterFuncaoPOrId(funcao.getId()));
        return usuario;
    }
    
    public static void excluirUsuario(Usuario usuario) throws SQLException{
        
        String query = "UPDATE usuario SET removido=true WHERE usuario.id = ?";
        
        try (Connection conn = ConnectionUtils.getConnection();
                PreparedStatement stmt = conn.prepareStatement(query)) {
            
            stmt.setLong(1, usuario.getId());
            
            stmt.executeUpdate();
        }
    }
    
    public static void alterarUsuario(Usuario usuario) throws SQLException{
        
        String query = "UPDATE usuario SET nome=?, sobre_nome=?, sexo=?, da_admissao, "
                + "funcao=? telefone=? WHERE usuario.id =?";
        
        try (Connection conn = ConnectionUtils.getConnection();
                PreparedStatement stmt = conn.prepareStatement(query)) {
            
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getSobrenome());
            stmt.setString(3, usuario.getSexo());
            java.sql.Date data = new java.sql.Date(usuario.getDtAdmissao().getTime());
            stmt.setDate(4, data);
            stmt.setLong(5, usuario.getId());
            stmt.setString(6, usuario.getTelefone());
            stmt.executeUpdate();
        }
    }
    
    
}

