--COMANDOS SQL

drop table if exists veiculo;


create table veiculo(
codigo serial,
placa varchar(7),
modelo varchar(255),
ano int,
valor float,
primary key(codigo)
);


drop table if exists loja;

create table loja(
codigo serial,
nome varchar(255),
primary key(codigo)
);

drop table if exists loja_veiculo;

create table loja_veiculo(
cod_loja int,
cod_veiculo int,

constraint fk_cod_loja 
	foreign key (cod_loja) references loja(codigo),

constraint fk_cod_veiculo 
	foreign key (cod_veiculo) references veiculo(codigo)
);

drop table if exists endereco;

create table endereco(
	codigo serial,
	cep varchar(8),
	logradouro varchar(255),
	complemento varchar(255),
	numero int,
	primary key(codigo)
);

drop table if exists cliente;

create table cliente(
	codigo serial, 
	nome varchar(255),
	cpf varchar(11),
	primary key(codigo)
);

drop table if exists endereco_cliente;

create table endereco_cliente(
	codigo_endereco int,
	codigo_cliente int,
	constraint fk_cod_endereco 
	foreign key (codigo_endereco) references endereco(codigo),

	constraint fk_cod_cliente
	foreign key (codigo_cliente) references cliente(codigo)
);

drop table if exists endereco_loja;

create table endereco_loja(
	codigo_endereco int,
	codigo_loja int,
	constraint fk_cod_endereco 
	foreign key (codigo_endereco) references endereco(codigo),

	constraint fk_cod_loja
	foreign key (codigo_loja) references loja(codigo)
);


drop table if exists tipo;

create table tipo(
	codigo serial,
	descricao varchar(255),
	primary key(codigo)
);

drop table if exists veiculo_tipo;

create table veiculo_tipo(
	codigo_tipo int,
	codigo_veiculo int,
	constraint fk_cod_tipo 
	foreign key (codigo_tipo) references tipo(codigo),

	constraint fk_cod_veiculo 
	foreign key (codigo_veiculo) references veiculo(codigo)
);

drop table if exists vendedor;

create table vendedor(
	codigo serial,
	nome varchar(255),
	primary key(codigo)
);


drop table if exists venda;

create table venda(
	codigo serial,
	codigo_veiculo int,
	codigo_vendedor int,
	codigo_cliente int,
	codigo_loja int,
	valor float,
	desconto float,
	dhvenda timestamp,

	primary key(codigo),
	
	constraint fk_cod_veiculo 
	foreign key (codigo_veiculo) references veiculo(codigo),

	constraint fk_cod_vendedor 
	foreign key (codigo_vendedor) references vendedor(codigo),
	
	constraint fk_cod_cliente 
	foreign key (codigo_cliente) references cliente(codigo),
	
	constraint fk_cod_loja 
	foreign key (codigo_loja) references loja(codigo)

);