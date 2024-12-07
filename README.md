<h1 align="center">Forum Hub </h1>


<div align="center">
    <img src="https://img.shields.io/badge/Java-21%2B-blue" alt="Java Badge">
    <img src="https://img.shields.io/badge/Spring%20Boot-3.4.0-brightgreen" alt="Spring Boot Badge">
    <img src="https://img.shields.io/badge/Maven-4.0.0-purple" alt="Maven Badge">
    <img src="https://img.shields.io/badge/MySQL-8.0-orange" alt="MySQL Badge">
    <img src="https://img.shields.io/badge/Flyway-9.5.0-red" alt="Flyway Badge">
    <img src="https://img.shields.io/badge/JWT-Authentication-yellow" alt="JWT Badge">
</div>

<p align="center">
  <img loading="lazy" src="http://img.shields.io/static/v1?label=STATUS&message=EM%20DESENVOLVIMENTO&color=YELLOW&style=for-the-badge"/>
</p>

## Descrição
**Forum_Hub** é uma aplicação para gerenciamento de tópicos em fóruns. Ela inclui funcionalidades como registro, atualização, listagem, detalhamento e exclusão de tópicos, além de autenticação de usuários com JWT.  

---

## Tecnologias utilizadas
- **Java 21**
- **Spring Boot 3.4.0**
- **Spring Data JPA**
- **Spring Security com JWT**
- **MySQL**
- **Flyway para migrações de banco de dados**
- **Lombok**
- **Maven**

---

## Funcionalidades
1. **Autenticação de Usuários**:
   - Realizada via `AutenticacaoController`, utilizando JWT para autenticação segura.
   - Endpoint `/login`:
     - Recebe login e senha.
     - Retorna um token JWT para autenticação subsequente.

2. **Gerenciamento de Tópicos no Fórum**:
   - Implementado no `ForumController`.
   - **Endpoints**:
     - **POST `/forum`**: Registra um novo tópico.
     - **GET `/forum`**: Lista tópicos visíveis, com paginação e ordenação por data de criação.
     - **GET `/forum/{id}`**: Retorna detalhes de um tópico específico.
     - **PUT `/forum`**: Atualiza informações de um tópico existente.
     - **DELETE `/forum/{id}`**: Marca um tópico como oculto (soft delete).

---

## Configuração do Ambiente

### Pré-requisitos
- **Java 21+**
- **MySQL** instalado e configurado.
- **Maven** para gerenciamento de dependências.

### Configuração do Banco de Dados
Edite o arquivo `application.properties` com suas credenciais:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/seu_banco
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.jpa.hibernate.ddl-auto=none
spring.flyway.enabled=true

```
## Como executar o projeto

1. Clone este repositório.
2. Configure o banco de dados no arquivo `application.properties` ou `application.yml`.
3. Execute o comando abaixo para compilar e rodar o projeto:
   ```bash
   mvn spring-boot:run
