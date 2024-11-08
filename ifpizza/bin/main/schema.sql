drop table if exists ingrediente;
create table ingrediente (
	id char(4) primary key not null,
	nome varchar(25) not null,
	tipo varchar(10) not null
);

drop table if exists pizza;
create table pizza (
	id identity primary key,
	data_criacao timestamp not null,	
	nome varchar(50) not null
);

drop table if exists pizza_ingrediente;
create table pizza_ingrediente (
	pizza_id bigint,
	ingrediente_id char(4) not null
);
alter table pizza_ingrediente add foreign key (pizza_id) references pizza(id);
alter table pizza_ingrediente add foreign key (ingrediente_id) references ingrediente(id);

drop table if exists pedido;
create table pedido (
	id identity primary key,
	data timestamp not null,	
	nome varchar(50) not null,
	cpf varchar(14),
	endereco varchar(50) not null,
	cidade varchar(50) not null,
	estado char(2) not null,
	cep varchar(10) not null
);

create table cartao (
	pedido_id bigint,
	numero varchar(16) not null,
	expiracao varchar(7) not null,
	cvv varchar(3) not null
);
alter table cartao add foreign key (pedido_id) references pedido(id);


drop table if exists pizza_pedido;
create table pizza_pedido (
	pizza_id bigint,
	pedido_id bigint
);
alter table pizza_pedido add foreign key (pizza_id) references pizza(id);
alter table pizza_pedido add foreign key (pedido_id) references pedido(id);

drop table if exists cliente;
create table cliente (
	cliente_id identity primary key,
	nome_cliente varchar(200) not null,
	endereco varchar(200) not null ,
	telefone varchar(10)not null
);

drop table if exists agendamento;
create table agendamento (
    agendamento_id identity primary key,
    data_hora datetime, 
    descricao varchar(200) not null,
    cliente_id bigint
);
alter table agendamento add foreign key (cliente_id) references cliente(cliente_id);







