# DS Posts

Este projeto foi desenvolvido no curso Full Stack Spring React da <a href="https://devsuperior.com.br/" target="_blank">DevSuperior</a> no módulo NoSQL, ele consiste no desenvolvimento de um sistema de posts e comentários utilizando o banco de dados <a href="https://www.mongodb.com/" target="_blank">MongoDB</a>, que é um banco de dados que não utiliza o modelo padrão relacional de colulas e tabelas como por exemplo: SQL Server, MySQL, dentre outros. Uma das grandes vantagens dos bancos de dados NoSQL está na sua alta velocidade em realizar as consultas, porém uma das desvantagens está no tamanho da base de dados que são maiores quando comparados com bancos relacionais, para maiores informações segue um vídeo explicando de forma mais detalhada as diferenças entre bancos relacionais e NoSQL: <a href="https://youtu.be/c6h5eR0TvfU" target="_blank">Link</a>

Abaixo segue uma descrição do sistema e as tecnologias implementadas:

## **Tecnologias**

- Linguagem de programação: Java 11
- Framework: Spring Boot 2.6.4
- Banco de dados Mongo DB 4.4.3-bionic
- MongoDB Compass para acessar a base graficamente
- Docker para criação do container do banco
- Ferramenta para testes de requisição Postman
- VS Code como IDE de desenvolvimento
- WSL2 (Ubuntu 20.04) como ambiente de desenvolvimento

## **Modelagem do Sistema**

1. Modelo conceitual

![conceptual model](/images/conceptualModel.png)

2. Modelo de agregação

![aggregation model](/images/aggregationModel.png)

3. Exemplo

![exemple](/images/exemple.png)

## Imagens do sistema

1. Classes e IDE

![class and IDE](/images/class.png)

2. Executando banco em container Docker

![container](/images/container_docker.png)

4. MongoDB Compass

![mongo compass](/images/compass.png)

## Endpoints

5. All users (consulta todos os usuários)

![endpoit all users](/images/endpoint_all_users.png)

6. User by id (consulta usuário por Id)

![endpoit user by id](/images/endpoint_user_by_id.png)

7. User posts (consulta posts do usuário)

![endpoit user by posts](/images/endpoint_user_posts.png)

7. New user (Adiciona usuário)

![endpoit user by posts](/images/endpoint_new_user.png)

7. Update user (Altera usuário pelo Id)

![endpoit user by posts](/images/endpoint_update_user.png)

7. Delete user (Delete usuário pelo Id)

![endpoit user by posts](/images/endpoint_delete_user.png)

7. Post by id (Consulta post pelo Id)

![endpoit user by posts](/images/endpoint_post_by_id.png)

7. Post by title (Consulta posts pelo texto no título)

![endpoit user by posts](/images/endpoint_post_by_title.png)

7. Post full search (Consulta posts pelo texto no título ou corpo ou comentários e com intervalo de data)

![endpoit user by posts](/images/endpoint_post_full_search.png)

## Executando o projeto

### Requisitos

- Java JDK 11
- Maven
- IDE com suporte a Spring Boot
- Docker

Suba um container Docker do banco MongoDB com o comando abaixo em seu terminal:

```
docker run -d -p 27017:27017 -v /data/db --name mongo1 mongo:4.4.3-bionic
```

Baixe o código fonte e o extraia em seu diretório de preferência, exemplo (C:\Workspaces).

Importe o sistema com a sua IDE Java de preferência, recomendação (Spring Tools ou VS Code), aguarde o Maven baixar as dependências e depois execute o projeto.
