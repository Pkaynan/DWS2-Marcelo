delete from ingrediente;
delete from pizza;
delete from pizza_ingrediente;
delete from pedido;
delete from pizza_pedido;
delete from cartao;

insert into ingrediente (id, nome, tipo) values ('CTPY', 'Catupiry', 'BORDA');
insert into ingrediente (id, nome, tipo) values ('SMPL', 'Simples', 'BORDA');
insert into ingrediente (id, nome, tipo) values ('PRST', 'Presunto', 'PROTEINA');
insert into ingrediente (id, nome, tipo) values ('CARN', 'Carne', 'PROTEINA');
insert into ingrediente (id, nome, tipo) values ('TMTE', 'Tomate', 'VEGETAIS');
insert into ingrediente (id, nome, tipo) values ('RCLA', 'Rúcula', 'VEGETAIS');
insert into ingrediente (id, nome, tipo) values ('MSRL', 'Mussarela', 'QUEIJO');
insert into ingrediente (id, nome, tipo) values ('PROV', 'Provolone', 'QUEIJO');
