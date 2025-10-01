# Projeto Mottu Challenge - Sistema de Gestão de Motos

##  Descrição

Este projeto é uma aplicação Spring Boot desenvolvida para gerenciar o controle de **motos** e **galpões**, com funcionalidades completas de cadastro.
Ele simula um sistema interno de gerenciamento de ativos para empresas que operam com frotas de motos, como locadoras ou serviços de logística.

---
## Desenvolvedores
- **Julia Vasconcelos || RM:558785 || Turma: 2TDSPF**
- **Leonardo Cadena || RM:557528 || Turma: 2TDSPV**
- **Davi Gonzaga || RM:554890 || Turma: 2TDSPV**

## Usuários e credenciais 
### Usuário administrador (acesso total)

- Usuário: admin

- Senha: admin

**Descrição: possui acesso a todas as funcionalidades do sistema.**

### Usuário com acesso limitado

- Usuário: julia

- Senha: julia123

**Descrição: conta com permissões restritas.**

## Tecnologias Utilizadas

- **Java**
- **Spring Boot**
  - Spring Data JPA
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
  

---


### Pré-requisitos:
- JDK instalado
- Maven ou Gradle
- IDE (IntelliJ, Eclipse, VSCode)

