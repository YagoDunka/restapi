insert into categoria(id,descricao, status)values(1, 'cereal', true);
insert into categoria(id,descricao, status)values(2, 'bebidas', true);

insert into produto(id, descricao, preco, estoque, categoria_id) values (1, 'milho', '10.5', 10, 1);
insert into produto(id, descricao, preco, estoque, categoria_id) values (2, 'arroz', '5.5', 150, 1);
insert into produto(id, descricao, preco, estoque, categoria_id) values (3, 'coca', '8', 200, 2);