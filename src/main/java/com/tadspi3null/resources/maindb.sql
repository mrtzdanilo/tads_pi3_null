/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  mverissimo
 * Created: Mar 31, 2018
 */

CREATE DATABASE IF NOT EXISTS ProjetoIntegrador3;

USE projetointegrador3;

CREATE TABLE livro (
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR (100) NOT NULL,
    valor VARCHAR (20) NOT NULL,
    descricao VARCHAR (255),
    idioma VARCHAR (50) NOT NULL,
    autor VARCHAR (100) NOT NULL,
    editora VARCHAR (100) NOT NULL,
    edicao VARCHAR (5) NOT NULL,
    numero_paginas VARCHAR (10),
    isbn VARCHAR (20) NOT NULL,
    FOREIGN KEY (id_categoria) REFERENCES Categoria(id)
);

CREATE TABLE filial (
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    nome_fantasia VARCHAR (100) NOT NULL,
    inscricao_estadual VARCHAR (100) NOT NULL,
    CNPJ VARCHAR (20) NOT NULL,
    telefone VARCHAR(20),
    email VARCHAR(100),
    fax VARCHAR(20), 
)



private Endereco endereco;
    
    private String nomeFantasia;
    private String nome;
    private String CNPJ;
    private String inscricaoEstadual;
    
    private String telefone;
    private String fax;
    private String email;