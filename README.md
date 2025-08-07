# Spring Boot CRUD API

Este projeto é uma API RESTful para operações de CRUD (Create, Read, Update, Delete) desenvolvida com Spring Boot.

## Descrição

Este repositório contém um projeto de exemplo de uma API CRUD (Create, Read, Update, Delete) construída com Java e Spring Boot. É um ponto de partida ideal para entender os conceitos fundamentais de construção de APIs RESTful e a estrutura de um projeto Spring.

## Tecnologias Utilizadas

  * **Java
  * **Spring Boot:** 
  * **Spring Data JPA:** Para persistência de dados
  * **Maven:** Para gerenciamento de dependências
  * **Banco de Dados:** H2

## Como Executar o Projeto

1.  **Clone o repositório:**
    ```bash
    git clone https://github.com/GuilhermeAssisF/SpringBoot-Crud.git
    ```
2.  **Navegue até o diretório do projeto:**
    ```bash
    cd SpringBoot-Crud
    ```
3.  **Execute o projeto:**
    ```bash
    ./mvnw spring-boot:run
    ```

A aplicação estará disponível em `http://localhost:8080`.

## Endpoints da API

A seguir estão os endpoints da API disponíveis:

  * **`GET /api/v1/seu-recurso`**: Retorna uma lista de todos os recursos.
  * **`GET /api/v1/seu-recurso/{id}`**: Retorna um recurso específico pelo ID.
  * **`POST /api/v1/seu-recurso`**: Cria um novo recurso.
  * **`PUT /api/v1/seu-recurso/{id}`**: Atualiza um recurso existente.
  * **`DELETE /api/v1/seu-recurso/{id}`**: Deleta um recurso.

**Exemplo de corpo da solicitação para POST e PUT:**

```json
{
  "propriedade1": "valor1",
  "propriedade2": "valor2"
}
```

## Como Contribuir

1.  Faça um fork do projeto.
2.  Crie uma nova branch (`git checkout -b feature/sua-feature`).
3.  Faça commit de suas alterações (`git commit -m 'Adiciona nova feature'`).
4.  Faça push para a branch (`git push origin feature/sua-feature`).
5.  Abra um Pull Request.

## Licença

Este projeto está licenciado sob a Licença MIT. Veja o arquivo [LICENSE](https://www.google.com/search?q=LICENSE) para mais detalhes.

-----
