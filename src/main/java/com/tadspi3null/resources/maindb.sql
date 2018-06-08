
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
    sobrenome VARCHAR (100) NOT NULL,
    sexo VARCHAR (100) NOT NULL,
    funcao VARCHAR (100) NOT NULL,
    dt_admissao DATE NOT NULL,
    removido BOOLEAN NOT NULL DEFAULT FALSE
);

CREATE TABLE cliente (
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    id_endereco INTEGER NOT NULL,
    nome VARCHAR (100) NOT NULL,
    sobrenome VARCHAR (100) NOT NULL,
    sexo VARCHAR (100) NOT NULL,
    cpf VARCHAR (20) NOT NULL,
    dt_nascimento DATE NOT NULL,
    FOREIGN KEY (id_endereco) REFERENCES Endereco(id),
    removido BOOLEAN NOT NULL DEFAULT FALSE
);

CREATE TABLE venda (
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    id_usuario INTEGER NOT NULL,
    id_filial INTEGER NOT NULL,
    id_cliente INTEGER,
    data_venda DATE NOT NULL,
    FOREIGN KEY (id_usuario) REFERENCES usuario (id),
    FOREIGN KEY (id_filial) REFERENCES filial (id),
    FOREIGN KEY (id_cliente) REFERENCES cliente (id)
);

CREATE TABLE item_venda(
    item_venda_id INTEGER PRIMARY KEY AUTO_INCREMENT,
    id_venda INT NOT NULL,
    id_livro INT NOT NULL,
    valor_unitario FLOAT NOT NULL,
    quantidade INTEGER NOT NULL,
    FOREIGN KEY (id_livro) REFERENCES Livro (id),
    FOREIGN KEY (id_venda) REFERENCES Venda (id)
    );



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



INSERT INTO categoria (nome, descricao)
VALUES ('Autobiografia','Autobiografia é um gênero literário em que uma pessoa narra a história da sua vida, trata-se de uma biografia escrita ou narrada pela pessoa biografada.'),
        ('Suspense', 'Livros de suspense são assim: páginas repletas de mistérios, que prendem a nossa atenção. E se você curte obras desse gênero.'),
        ('Fantasia', 'Livros que te levam a outra dimensão'),
        ('Fantasia', 'Livros que te levam a outra dimensão')


INSERT INTO livro (id_categoria, titulo, valor, descricao, idioma, autor, editora, edicao, numero_paginas, isbn)
VALUES (3, 'Desafio Infinito', 80.00, 'fantasia', 'portugues', 'Jim Starling', 'abril','1', '298', '343434' ),
        (2, 'Money', 56.00, 'fantasia', 'portugues', 'Salah W.', 'abril','1', '180', '342454' ),
        (3, 'Mulher Maravilha', 19.00, 'fantasia', 'portugues', 'Azzarelo Brian', 'Panini Books','2', '220', '564635' ),
        (1, 'Scar Tissue', 27.00, 'tragédias', 'portugues', 'Kiedis, Anthony', 'Panini Books','6', '330', '5345234' ),
        (2, 'Auto da Barca do Inferno', 34.00, 'história', 'portugues', 'Vicente,Gil', 'abril','1', '100', '123' ),
        (3, 'Animais Fantasticos', 102.00, 'fantasia', 'portugues', 'J. K. Rowling', 'Panini Books','3', '201', '28787' ),
        (1, '12 Licoes de Historia', 12.00, 'fantasia', 'portugues', 'Will Duran', 'abril','2', '258', '768765' ),
        (2, 'Hamlet', 23.00, 'fantasia', 'portugues', 'Shakespeare, William', 'abril','1', '98', '5465342' ),
        (1, 'Grandes Obras De Shakespeare', 23.00, 'fantasia', 'portugues', 'Shakespeare, William', 'abril','2', '1000', '5465342' ),
        (1, 'Nuca Deixe De Tentar', 23.00, 'fantasia', 'portugues', 'Jordan, Michael', 'abril','1', '98', '5465342' )


INSERT INTO endereco (rua, bairro, estado, cidade, numero, cep)
VALUES ('Rua Benedito','Santa cecilia', 'Rio de Janeiro', 'Rio de Janeiro', '1200', 033327-57),
        ('Rua Alencar','Grajaú', 'São Paulo', 'São Paulo', '1200', 033327-57),
        ('Rua Joazeiro','Vila Maria', 'Ceará', 'Sobral', '1200', 033327-57),
        ('Av Sargento Geraldo','Cidade Ademar', 'Sergipe', 'Aracaju', '1200', 033327-57),
        ('Rua Marli','Rio Bonito', 'Maranhão', 'São Luis', '1200', 033327-57)


INSERT INTO filial (nome_fantasia, inscricao_estadual, cnpj, telefone, email, fax, id_endereco)
VALUES ('Filial A', '772.974.364.630','91.381.008/0001-09', '5566-9294','filialA@gmail.com', 3632-1778, 1 ),
        ('Filial B', '478.546.291.395','19.037.231/0001-06', '2255-4323','filialB@gmail.com', 2344-7653, 2 ),
        ('Filial C', '803.088.129.183','16.085.640/0001-81', '2323-5664','filialC@gmail.com', 3439-5643, 3 ),
        ('Filial D', '008.975.135.020', '95.713.175/0001-52', '2132-4566','filialD@gmail.com', 3248-3453, 4 ),
        ('Filial E', '803.088.129.183', '45.050.358/0001-67', '3123-9876','filialE@gmail.com', 2324-8765, 5 )

INSERT INTO cliente (id_endereco, nome, sobrenome, sexo, cpf, dt_nscimento)
VALUES (2, 'Adalberto', 'Mourao', 'Masculio', '0134567890', '1992-12-12')

INSERT INTO usuario (nome, sobrenome, sexo, funcao, dt_admissao)
VALUES ('vendedorA','A','masculino','vendedor','2018-01-01')
        ('vendedorB','B','feminino','vendedor','2018-02-01')
        ('vendedorC','C','masculino','vendedor','2018-03-01')
