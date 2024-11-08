drop table if exists cliente;
create table cliente (
	id identity primary key,
	nome varchar(25) not null,
	endereco varchar(50) not null,
	telefone varchar(50) not null
);

drop table if exists agendamento;
create table agendamento (
	id identity primary key,
	data varchar(10) not null,
	hora varchar(10) not null,
	descricao text not null,
	cliente_id bigint not null
);
alter table agendamento add foreign key (cliente_id) references cliente(id);