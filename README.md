# springBetApp

Desenvolvendo uma aplicação de apostas em Java

### INTRODUÇÃO

Recentemente recebi de um processo seletivo, o desafio de desenvolver uma API REST que consiste em selecionar números aleatórios para apostas na loteria em uma semana. Segue os detalhes:

Objetivo:
* criar uma API REST que cria números aleatórios para apostas na loteria.

Escopo:
* um endpoint com email;
* um endpoint para listar as apostas em ordem de criação por email.

Requisitos:
* stack:
	- Java;
	- Spring;
	- Hibernate.

Com o tempo curto e falta de conhecimento técnico adequado, busquei materiais sobre os temas citados. Muitos dos conceitos aqui utilizados foram retirados do livro Learn Microservices with Spring Boot - A practical Approach to RESTful Services Using an Event-Driven Architecture, Cloud-Native Patterns, and Containerization . 


### 1.Definindo as ferramentas de desenvolvimento

Além dos requisitos apontados (Java, Spring e Hibernate), as seguintes soluções foram adicionadas a stack de desenvolvimento:

Visual Studio Code -  ferramenta de desenvolvimento versátil que pode incorporar dentre outras coisas, recursos do Eclipse® e IntelliJ IDEA;

Lombok -  biblioteca que auxilia no desenvolvimento de aplicações Java, simplificando a elaboração de códigos.


### 2.Arquitetura de três camadas

Para facilitar seu desenvolvimento, a arquitetura da aplicação foi dividida em camadas. A adoção desse modelo permite o desenvolvimento de cada módulo de forma independente, são elas: 
* camada de apresentação - a interface do usuário fica alocada aqui (front-end);
* camada de aplicação - as regras do negócio e os controles da aplicação ficam aqui (back-end);
* camada de dados - local onde os dados são armazenados.

Sendo assim, a aplicação ficou assim estruturada:

Lottery-App
* User Interface 
* Business Logic 
	- Controller
	- Service
	- Repository
* Database


### 3.Domínios

O domínio da aplicação foi montado com três entidades e duas relações conforme apresentado a seguir:
	
* Entidades:
	- User 
	// identifica o usuário que recebe os números da loteria);
	- Ticket 
	// identifica as apostas (números + jogador);
	- Bet 
	// recebe os seis números para a aposta);

* Relações:
	- user  e ticket são entidades independentes;
	- a aposta (bet) está atrelada ao user e ao ticket;

* Domínios:
	- domínio usuário:
		- User;
	- domínio apostas:
		- Bet;
		- Ticket.


### 4.Desenvolvimento

Definida as ferramentas, a arquitetura e os domínios da aplicação, chegou a hora de desenvolver a aplicação com foco nas seguintes tarefas:

- Criação de um serviço básico.
- Criação de uma API para acessar o serviço.
- Criação de um banco de dados para armazenar as apostas.

**Iniciando o projeto:**

A base da aplicação Spring® foi iniciada com os seguintes parâmetros:

* Projeto:	
	- Maven Project;
* Linguagem:
	- Java;
* Spring Boot Version:
	- 2.4.2;
* Metadados
	- Packaging Jar;
	- Java 14;
* Dependências	
	- Spring Web;
	- Lombok;
	- Validation.

**Estrutura:**

Domínios e classes:
- src.app.lottery.bet
	- Bet.java
	- Ticket.java
- src.app.lottery.user
	- User.java

**Serviços:**

São as classes com as regras de negócio e dividem se em duas partes, interface, classe abstrata com a função de fornecer acesso ao serviço e implementação, contém a lógica do serviço em si.

- src.app.lottery.bet
	- BetGeneratorService.java 
	- BetGeneratorServiceImpl.java
	- TicketGeneratorService.java
	- TicketGeneratorServiceImpl.java

BetGeneratorServiceImpl - é a classe que gera os seis números da aposta (boa parte da lógica da aplicação está aqui) e está estruturada da seguinte maneira:

* implementa a classe BetGeneratorService.java;
* define quais números podem ser sorteados (01 à 60);
* sorteia os números;
* adiciona os números em uma lista excluindo  possíveis repetições;
* retorna uma lista com os seis números sorteados.

TicketGeneratorServiceImpl - classe que vincula a aposta a um apostador criando um bilhete:

* implementa a classe BetService.java;
* verifica a aposta e usuário;
* adiciona o usuário ao email;
* retorna um bilhete com usuário e aposta.

**API:**

A verificação dos serviços na camada de apresentação fica por conta das APIs REST contida nas classes controladoras. Desse modo, é possível validar a aplicação em uma página HTTP simples mantendo o back-end isolado.
Nessa etapa, além das classes controladoras, criei os DTOs - Data Transfer Objects. São as classes que possuem a função de filtrar os  dados antes de serem utilizados pela aplicação. A adoção dessa prática ajuda na proteção de dados sensíveis e reduz o número de requisições ao bando de dados. Segue a estrutura :

- src.app.lottery.bet
	- TicketControler.java
	- TicketDTO.java
- src.app.lottery.user
	- UserDTO.java

UserDTO -  classe que faz a filtragem do usuário retornando apenas o email no formato “name@mail.com”.

TicketDTO - classe que filtra os dados do bilhete com o email do usuário e a listagem com os números selecionados. 

TicketController - é a classe que implementa a API. 

**Repositório:** 

O banco de dados foi implementado utilizado o MySQL, Hibernate e JPA e foi implementado seguindo as seguintes tarefas:
* armazenar os bilhetes com as apostas e apostador;
* criar um novo serviço para recuperar essas apostas.

Os módulos foram adicionados ao projeto, as classes User, Bet e Ticket foram transformadas em entidades do bando de dados e os controles da aplicação foram implementados para gravar e consultar a base de dados. A administração do banco de dados fica por conta das classes UserRepository e TicketRepository.


### 5.Considerações

Devido a falta de conhecimento técnico adequado, uma semana não foi o suficiente para a conclusão do desafio. No entanto, foi um período de aprendizado com muita leitura de documentações, muitos erros e muitas correções. Mesmo assim, foi possível colocar em prática os conceitos estudados e, apesar de um pequeno atraso, a aplicação está funcional e os desafio proposto foi concluído.

Por fim, a estrutura da aplicação ficou assim definida:

LotteryApp:

Domínios e classes:

- src.app.lottery.user
	- User.java	
	- UserDTO.java
	- UserRepository.java

- src.app.lottery.bet
	- Bet.java
	- BetController.java
	- BetGeneratorService.java
	- BetGeneratorServiceImpl.java
	- Ticket.java
	- TicketController.java
	- TicketDTO.java
	- TicketGeneratorService.java
	- TicketGeneratorServiceImpl.java
	- TicketRepository.java


### REFERÊNCIAS

Livro:

*Moisés Macero Garcia - Learn Microservices with Spring Boot - A practical Approach to RESTful Services Using an Event-Driven Architecture, Cloud-Native Patterns, and Containerization.*

Documentação:

- Spring® Framework - https://spring.io.
- Lombok -  https://projectlombok.org.
- Hibernate - https://hibernate.org.


### KEYWORDS: Java; Spring; MySQL; Software Development;  Software Architecture.
