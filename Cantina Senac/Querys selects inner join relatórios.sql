-- Querys para efetuar a visualização de relatórios

-- TUDO

select (select nome from cliente where matricula = clienteFK), (select nome from funcionario where codigo = funcionarioFK), datavenda, 
(select nomeProduto from produto  where codigo = itemdevenda.id_produto_fk) from venda inner join itemdevenda on  venda.id_venda = itemDevenda.idvenda_FK

-- Venda por determinado cliente 

select (select nome from cliente where matricula = clienteFK), datavenda, 
(select nomeProduto from produto  where codigo = itemdevenda.id_produto_fk) from venda inner join itemdevenda on  venda.id_venda = itemDevenda.idvenda_FK
and venda.clienteFK = '631120051'


-- Venda por determinado funcionario 

select  (select nome from funcionario where codigo = funcionarioFK), datavenda, 
(select nomeProduto from produto  where codigo = itemdevenda.id_produto_fk) from venda inner join itemdevenda on  venda.id_venda = itemDevenda.idvenda_FK
and funcionarioFK = '2'


-- Venda por um determinado mês

select (select nome from cliente where matricula = clienteFK), (select nome from funcionario where codigo = funcionarioFK), datavenda, 
(select nomeproduto from produto  where codigo = itemdevenda.id_produto_fk) from venda inner join itemdevenda on  venda.id_venda = itemDevenda.idvenda_FK
and venda.datavenda  = '2014-06-29' or venda.dataVenda < '2014-06-29'

