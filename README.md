# Backend da Aplicação TechNote - Notas Informativas

## Sobre o Projeto

<p>Backend de uma aplicação Web para criação, atualização e manipulação de notas informativas, para ser utilizado como mural de ideias. 
  Forma de visualizar pensamentos e conceitos sobre determinados assuntos.</p>
<p>Aplicação desenvolvida em Java usando o framework SpringBoot. 
  Back-end responsável por lidar com a lógica de negócios, manipulação de dados e comunicação com o banco de dados PostgreSQL, utilizando Spring Data JPA.</p>

## Tecnologias Utilizadas
Projeto construido utilizando Java com framework SpringBoot e SpringData JPA para realizar a comunicação com o Banco de dados relacional, sendo o PostgreSQL.

### Padrão do Projeto
Utilizando o padrão de projeto MVC(Model-View-Controller), com o foco na organização e separação de responsabilidades.

## Integrações
Projeto é integrado com o Banco de dados PostgreSQL através do Driver e comunica-se com o Front-end através da API rest.

## Configuração do Banco de Dados PostgreSQL
- Instale o PostgreSQL em sua máquina, se ainda não estiver instalado.
- Crie um banco de dados para a aplicação utilizando o comando:
CREATE DATABASE "techNote"<br>
    WITH<br>
    OWNER = postgres<br>
    ENCODING = 'UTF8'<br>
    LOCALE_PROVIDER = 'libc'<br>
    CONNECTION LIMIT = -1<br>
    IS_TEMPLATE = False;<br>

- Verificar variaveis de ambiente para realizar a conexão com o Banco em **application.properties**. 

A tabela do banco deve ser criada automaticamente com a anotação: 

*spring.jpa.hibernate.ddl-auto=update*

<a href="https://github.com/varela-s-matheus/TechNote--Front-end" target="_blank">Acessar Front-end desta aplicação</a>

## Contatos

<a href="https://linkedin.com/in/varela-s-matheus" target="_blank">
  <img align="center" src="https://img.shields.io/badge/-MatheusVarela-05122A?style=flat&logo=linkedin" alt="linkedin"/>
</a>
<a href="https://www.instagram.com/varela_matheuus/" target="_blank">
 <img align="center" src="https://img.shields.io/badge/-MatheusVarela-05122A?style=flat&logo=instagram" alt="instagram"/>
</a>
