# Sistema de Reservas de Hotéis

Projeto desenvolvido para entrega final do Modulo Programação Web do curso Backend Java do Programa B3 Inclua+ ministrado pela Ada.

Este é um projeto de API REST para gerenciamento de reservas de hotéis, desenvolvido em Java com Spring Boot e Hibernate. A API permite a criação, leitura, atualização e exclusão de hotéis, quartos e reservas.

## Funcionalidades

- **Gerenciamento de Hotéis**
  - Criar, listar, atualizar e deletar hotéis.
  
- **Gerenciamento de Quartos**
  - Criar, listar, atualizar e deletar quartos, vinculados a um hotel.
  
- **Gerenciamento de Reservas**
  - Criar, listar, atualizar e deletar reservas de quartos.

## Tecnologias Utilizadas

- **Java 21**
- **Spring Boot**
- **Spring Data JPA**
- **PostgreSQL**
- **Maven**


### Descrição dos Pacotes

- **controllers**: Contém as classes responsáveis por gerenciar as requisições HTTP e interagir com os serviços.
- **dtos**: Contém os objetos de transferência de dados (DTOs) utilizados para comunicação entre o cliente e a API.
- **entities**: Contém as classes que representam as entidades do banco de dados.
- **exceptions**: Contém as classes de exceção personalizadas para tratamento de erros.
- **repositories**: Contém as interfaces de repositório que se comunicam com o banco de dados.
- **services**: Contém a lógica de negócio do sistema.

## Como Executar o Projeto

1. **Clone o Repositório**
   ```bash
   git clone https://github.com/seuusuario/sistema-gerenciamento-hotel
   ```
2. **Navegue até o Diretório do Projeto**
   ```bash
   cd sistema-gerenciamento-hotel
   ```
3. **Execute o Projeto**
   ```bash
   mvn spring-boot:run
   ```
   

