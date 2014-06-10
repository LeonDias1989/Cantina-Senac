create table cliente(
matricula	varchar(9) primary key, 
nome		varchar(40),
email		varchar(40), 
saldo 		decimal(10,2), 
senha		varchar(8)

)


select * from cliente

create table produto(
codigo		varchar(10) primary key, 
nome		varchar(25) not null, 
tipo		varchar(25), 
preco		decimal(10,2)

)

select * from produto

create table funcionario(
id_funcionario 	varchar(20) primary key, 
nome		varchar(40),  
senha		varchar(8)

)

select * from funcionario