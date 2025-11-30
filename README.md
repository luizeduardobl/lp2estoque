Sistema de Estoque em Java (Spring Boot + JavaFX)

Este projeto consiste em uma API de controle de produtos usando Spring Boot e um cliente em JavaFX para interação com o usuário.
A aplicação permite cadastrar produtos e se comunica com o backend através de requisições HTTP.

Tecnologias utilizadas:
- Java 17+
- Spring Boot
- JavaFX
- Maven

Estrutura do projeto
ProjetoEstoque/      -> API (Spring Boot)
cliente-estoque/     -> Interface gráfica em JavaFX

Como executar
1) Rodando o backend (API)

Abra o projeto na IDE
Vá até: ProjetoEstoque/src/main/java/com/estoque/api/ApiApplication.java
Execute a classe
A API iniciará na porta padrão: http://localhost:8080/produtos

2) Rodando o cliente JavaFX
Acesse o módulo: cliente-estoque/src/main/java/com/estoque/Launcher.java
Execute a classe
A interface será aberta permitindo cadastro de produtos
