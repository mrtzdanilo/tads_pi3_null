
CREATE DATABASE IF NOT EXISTS ProjetoIntegrador3;

USE projetointegrador3;

CREATE TABLE categoria (
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR (100) NOT NULL,
    descricao VARCHAR (255)
);

CREATE TABLE livro (
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    id_categoria INTEGER NOT NULL,
    FOREIGN KEY (id_categoria) REFERENCES categoria (id),
    titulo VARCHAR (100) NOT NULL,
    valor VARCHAR (20) NOT NULL,
    descricao VARCHAR (255),
    idioma VARCHAR (50) NOT NULL,
    autor VARCHAR (100) NOT NULL,
    editora VARCHAR (100) NOT NULL,
    edicao VARCHAR (5) NOT NULL,
    numero_paginas VARCHAR (10),
    isbn VARCHAR (20) NOT NULL,
    removido BOOLEAN NOT NULL DEFAULT FALSE
);

CREATE TABLE endereco (
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    rua VARCHAR (100) NOT NULL,
    bairro VARCHAR (100) NOT NULL,
    estado VARCHAR (100) NOT NULL,
    cidade VARCHAR (100) NOT NULL,
    numero VARCHAR (100) NOT NULL,
    cep VARCHAR (100) NOT NULL
);


CREATE TABLE filial (
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    nome_fantasia VARCHAR (100) NOT NULL,
    inscricao_estadual VARCHAR (100) NOT NULL,
    cnpj VARCHAR (20) NOT NULL,
    telefone VARCHAR(20),
    email VARCHAR(100),
    fax VARCHAR(20), 
    id_endereco INTEGER NOT NULL,
    removido BOOLEAN NOT NULL DEFAULT FALSE,
    FOREIGN KEY (id_endereco) REFERENCES Endereco(id)
);

CREATE TABLE livro_filial (
    PRIMARY KEY(id_filial, id_livro),
    estoque INTEGER NOT NULL DEFAULT 0,
    id_filial INTEGER NOT NULL,
    id_livro INTEGER NOT NULL,
    FOREIGN KEY (id_livro) REFERENCES livro (id),
    FOREIGN KEY (id_filial) REFERENCES Filial (id)
);

CREATE TABLE usuario (
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR (100) NOT NULL,
    sobre_nome VARCHAR (100) NOT NULL,
    sexo VARCHAR (100) NOT NULL,
    funcao VARCHAR (100) NOT NULL,
    dt_admissao VARCHAR (100) NOT NULL,
    removido BOOLEAN NOT NULL DEFAULT FALSE
);

INSERT INTO categoria (nome, descricao)
VALUES ('Autobiografia','Autobiografia é um gênero literário em que uma pessoa narra a história da sua vida, trata-se de uma biografia escrita ou narrada pela pessoa biografada.'),
('Suspense', 'Livros de suspense são assim: páginas repletas de mistérios, que prendem a nossa atenção. E se você curte obras desse gênero.')

DELIMITER //

CREATE TRIGGER insert_livro_filial_after_livro_insert
AFTER INSERT
   ON livro FOR EACH ROW
BEGIN
   -- Insert record into audit table
   INSERT INTO livro_filial
   ( id_filial,
     id_livro)
   SELECT id, NEW.id from filial;
END; //

DELIMITER ;

DELIMITER //

CREATE TRIGGER insert_livro_filial_after_filial_insert
AFTER INSERT
   ON filial FOR EACH ROW
BEGIN
   -- Insert record into audit table
   INSERT INTO livro_filial
   ( id_filial,
     id_livro)
   SELECT NEW.id, id from livro;
END; //

DELIMITER ;
