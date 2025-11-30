Sistema de Estoque em Java (Spring Boot + JavaFX)

Este projeto consiste em uma API de controle de produtos usando Spring Boot e um cliente em JavaFX para interação com o usuário.
A aplicação permite cadastrar produtos e se comunica com o backend através de requisições HTTP.

Tecnologias utilizadas:
- Java 17+
- Spring Boot
- JavaFX
- Maven


Como executar
1) Rodando o backend (API)

Abra o projeto na IDE
Vá até: ProjetoEstoque/src/main/java/com/estoque/api/ApiApplication.java

Ao executar a classe, a API iniciará na porta padrão: http://localhost:8080/produtos

Na porta 8080/produtos estarão listados todos os produtos cadastrados pelo lado do cliente no JavaFX. Caso deseje ver apenas um único produto cadastrado, é possível pesquisar pelo ID.

Para isto, basta digitar, por exemplo, para buscar o produto com ID 1: http://localhost:8080/produtos/1 

O ID é atribuido pela ordem cadastrada, portanto o item que receberá o ID 1 será o primeiro cadastrado, e assim sucessivamente.

2) Rodando o cliente JavaFX (É importante que antes de rodar o cliente JavaFX a API já esteja em execução)
   
Acesse o módulo: cliente-estoque/src/main/java/com/estoque/Launcher.java
Execute a classe
A interface será aberta permitindo cadastro de produtos
