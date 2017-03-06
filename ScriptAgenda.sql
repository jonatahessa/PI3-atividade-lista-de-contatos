create database Agenda;
use Agenda;
Create Table Contato (
idContato int not null auto_increment primary key,
ContatoNome varchar (255) not null,
ContatoEmail varchar (255) not null,
ContatoTelefone varchar (20),
ContatoCelular varchar (20),
ContatoNascimento varchar (20) not null,
ContatoEnabled varchar (10) not null,
ContatoAdicionadoEm timestamp
);
