# Backend da Aplicação MVC de Notas Informativas

<p>Bem-vindo ao README do backend da nossa aplicação de notas informativas! 
  Neste documento, você encontrará uma visão geral do backend, incluindo sua estrutura, tecnologias utilizadas e como integrar com o banco de dados PostgreSQL.</p>

## Visão Geral

<p>Backend de uma aplicação Web para criação, atualização e manipulação de notas informativas, para ser utilizado como mural de ideias. 
  Forma de visualizar pensamentos e conceitos sobre determinados assuntos.</p>
<p>Nossa aplicação é desenvolvida em Java usando o framework Spring Boot. 
  Ele é responsável por lidar com a lógica de negócios, manipulação de dados e comunicação com o banco de dados PostgreSQL, utilizando Spring Data JPA.</p>

## Tecnologias Utilizadas
### Linguagem de Programação:
- Java
### Framework Web:
- Spring Boot
### Banco de Dados:
- PostgreSQL

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

