# Projeto Mottu Challenge - Sistema de Gestão de Motos

##  Descrição

Este projeto é uma aplicação Spring Boot desenvolvida para gerenciar o controle de **motos** e **galpões**, com funcionalidades completas de cadastro.
Ele simula um sistema interno de gerenciamento de ativos para empresas que operam com frotas de motos, como locadoras ou serviços de logística.

---
## Desenvolvedores
- **Julia Vasconcelos || RM:558785 ||Turma: 2TDSPF**
- **Leonardo Cadena || RM:557528 || Turma: 2TDSPV**
- **Davi Gonzaga || RM:554890 || Turma: 2TDSPV**

## Tecnologias Utilizadas

- **Java**
- **Spring Boot**
  - Spring Data JPA
  - Spring Cache
  - Spring Security
- **Lombok** para simplificar a criação de classes
- **Flyway**
- **Thymeleaf**


---

##  Principais Funcionalidades

- Cadastro e atualização de **motos**
- Gerenciamento de **galpões** (local de armazenamento)
     - Crud de Galpões
        - Listar 
        - Editar
        - Excluir
        - Adicionar
- Rotas protegidas por Spring Security
- Exceções
- Busca de motos por:
  - **Placa**
  - **Chassi**
  - **Modelo**
  - **Status**
-  Implementação de **caching** com Spring Cache para otimizar performance nas consultas
  

---


### Pré-requisitos:
- JDK instalado
- Maven ou Gradle
- IDE (IntelliJ, Eclipse, VSCode)

