create database contracheque;

use contracheque;

create table usuario(
	id int primary key auto_increment,
    nome nvarchar(150) not null,
    login nvarchar(11) not null,
    senha nvarchar(10) not null,
    ativo bit not null,
    perfil bit not null,
    Empresa nvarchar(150)
);

create table dados(
	id int primary key auto_increment,
    folha_competencia varchar(7) not null,
    cpf_funcionario varchar(11) not null,
    nome_completo varchar(150) not null,
    tipo_codigo integer not null,
    descricao nvarchar(100) not null,
    salario numeric(10,2) not null,
    dt_nascimento date not null,
    cargo  varchar(100) not null,
    folha_valor numeric(10,2) not null
);