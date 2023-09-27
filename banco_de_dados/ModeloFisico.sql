CREATE DATABASE recodeviagens
default character set utf8
default collate utf8_general_ci;


CREATE TABLE agencia (
    Cnpj INTEGER PRIMARY KEY auto_increment,
	Unidade VARCHAR(20) not null,
	Nome_Fantasia VARCHAR(30) default 'RecodeViagens',
    Telefone VARCHAR(15)  not null,
    Email VARCHAR(50) not null,
    Endereco VARCHAR(50) not null
);
6

CREATE TABLE departamento (
    Cod_Departamento INTEGER PRIMARY KEY  auto_increment,
    Nome_Departamento VARCHAR(15) NOT NULL,
    Cnpj INTEGER  NOT NULL,
    FOREIGN KEY (Cnpj) REFERENCES Agencia (Cnpj)
);


CREATE TABLE cliente (
    Cpf_Cli VARCHAR(11) not null,
    Nome_Cli VARCHAR(50) not null,
    Email_Cli VARCHAR(50) not null,
    Telefone_Cli VARCHAR(11) not null,
    PRIMARY KEY (Cpf_Cli)
);


CREATE TABLE destino (
    Id_Destino INTEGER auto_increment,
	Nome_Destino VARCHAR(20) not null,
    Preco_Destino DOUBLE not null,
    Categoria_Destino VARCHAR(20) not null,
    Qtd_Disponivel INTEGER not null,
    Condicao VARCHAR(20) not null default 'Sem desconto',
    PRIMARY KEY (Id_Destino)
);

CREATE TABLE passagem (
    Id_Passagem INTEGER PRIMARY KEY auto_increment,
    Quantidade INTEGER not null,
    Id_Destino INTEGER not null,
	FOREIGN KEY (Id_Destino) REFERENCES Destino (Id_Destino)
 
);

CREATE TABLE orcamento(
	 idOrcamento INTEGER PRIMARY KEY auto_increment,
	 Quantidade INTEGER not null,
     Destino VARCHAR(20) not null,
     data_ida date,
     data_volta date,
	 PrecoTotal DOUBLE not null,
	 Cpf_Cli VARCHAR(11) not null,
	 Id_Passagem INTEGER not null,
	 FOREIGN KEY (Id_Passagem) REFERENCES Passagem (Id_Passagem),
     FOREIGN KEY (Cpf_Cli) REFERENCES Cliente (Cpf_Cli)
);

CREATE TABLE pedido (
    Num_Pedido INTEGER PRIMARY KEY auto_increment,
	Data_Pedido DATE not null,
    Cod_Departamento INTEGER not null,
	Cpf_Cli VARCHAR(11) not null,
    PrecoTotal DOUBLE not null,
    Forma_Pag VARCHAR(20) not null default 'Cartão de Crédito',
    statusPedido VARCHAR(20) default 'Em processamento',
    FOREIGN KEY (Cod_Departamento) REFERENCES Departamento (Cod_Departamento),
    FOREIGN KEY (Cpf_Cli) REFERENCES Cliente (Cpf_Cli)
);

INSERT INTO DESTINO (Nome_Destino, Preco_Destino, Categoria_Destino, Qtd_Disponivel, Condicao) VALUES ("RECIFE", 500.00, "NACIONAL", 250, default);
INSERT INTO DESTINO (Nome_Destino, Preco_Destino, Categoria_Destino, Qtd_Disponivel, Condicao) VALUES ('PORTO DE GALINHAS', 650.00, 'NACIONAL', 300, default);
INSERT INTO DESTINO (Nome_Destino, Preco_Destino, Categoria_Destino, Qtd_Disponivel, Condicao) VALUES ('SALVADOR', 700.00, 'NACIONAL', 320, default);
INSERT INTO DESTINO (Nome_Destino, Preco_Destino, Categoria_Destino, Qtd_Disponivel, Condicao) VALUES ('RIO DE JANEIRO', 889.00, 'NACIONAL', 155, default);
INSERT INTO DESTINO (Nome_Destino, Preco_Destino, Categoria_Destino, Qtd_Disponivel, Condicao) VALUES ('SÃO PAULO', 729.00, 'NACIONAL', 189, default);
INSERT INTO DESTINO (Nome_Destino, Preco_Destino, Categoria_Destino, Qtd_Disponivel, Condicao) VALUES ('LONDRES', 1250.00, 'INTERNACIONAL', 50, default);
INSERT INTO DESTINO (Nome_Destino, Preco_Destino, Categoria_Destino, Qtd_Disponivel, Condicao) VALUES ('PARIS', 1559.00, 'INTERNACIONAL', 75, default);
INSERT INTO DESTINO (Nome_Destino, Preco_Destino, Categoria_Destino, Qtd_Disponivel, Condicao) VALUES ('LISBOA', 1500.00, 'INTERNACIONAL', 120, default);