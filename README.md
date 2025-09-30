# Projeto Mottu Challenge - Sistema de Gestão de Motos

##  Descrição

Este projeto é uma aplicação Spring Boot desenvolvida para gerenciar o controle de **motos** e **galpões**, com funcionalidades completas de cadastro, consulta (com caching), paginação e integração com banco de dados H2. 

Ele simula um sistema interno de gerenciamento de ativos para empresas que operam com frotas de motos, como locadoras ou serviços de logística.

---
## Desenvolvedores
- **Julia Vasconcelos RM:558785 Turma: 2TDSPF**
- **Leonardo Cadena RM:557528 Turma: 2TDSPV**
- **Davi Gonzaga RM:554890 Turma: 2TDSPV**

## Tecnologias Utilizadas

- **Java 21**
- **Spring Boot**
  - Spring Web
  - Spring Data JPA
  - Spring Cache
- **Banco de Dados H2 (memória)**
- **Lombok** para simplificar a criação de classes
- **Spring Security**
- **Flyway**


---

##  Principais Funcionalidades

- Cadastro e atualização de **motos**
- Gerenciamento de **galpões** (local de armazenamento)
- Busca de motos por:
  - **Placa**
  - **Chassi**
  - **Modelo**
  - **Status**
-  Implementação de **caching** com Spring Cache para otimizar performance nas consultas

---


### Pré-requisitos:
- JDK 17 instalado
- Maven ou Gradle
- IDE (IntelliJ, Eclipse, VSCode)

