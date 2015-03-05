drop table ACI_Aluno
drop table ACI_Responsavel

create table ACI_Responsavel ( 
	Email varchar(100) primary key,
	Nome varchar(50) not null,
	Telefone varchar(15) not null,
	Endereco varchar(100) not null
)

create table ACI_Aluno (
	RA varchar(5) primary key, 
	Nome varchar(50) not null,
	Email varchar(100) not null,
	Telefone varchar(15) not null,
	Endereco varchar(100) not null,
	Responsavel varchar(100) not null,
	constraint fkResp foreign key (Responsavel) references ACI_Responsavel(Email)
)

insert into ACI_Aluno values ('13185','Marina Guimar�es')
insert into ACI_Aluno values ('13195','Vict�ria Pedrazzoli')
insert into ACI_Aluno values ('13176','Jo�o Vitor Gon�alves')
insert into ACI_Aluno values ('13166','F�bio Ricci')
insert into ACI_Aluno values ('13181','Leonardo Picoli')

update ACI_ALUNO set Nome= 'viada1' where RA = '13166'

select * from ACI_Responsavel