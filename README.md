# 🏨 Hotel System

Sistema de gerenciamento de hotéis desenvolvido com **Java 21**, **Spring Boot**, **Spring Data JPA** e **MySQL**.

O projeto tem como objetivo gerenciar hóspedes, quartos e reservas, permitindo realizar operações como check-in, check-out e controle de disponibilidade dos quartos.

---

## 📋 Funcionalidades

### 👤 Gestão de Hóspedes
- Cadastro de hóspedes
- Consulta de hóspedes
- Atualização de dados
- Exclusão de registros

### 🛏️ Gestão de Quartos
- Cadastro de quartos
- Controle de disponibilidade
- Classificação por tipo
- Definição de valor da diária

### 📅 Gestão de Reservas
- Criação de reservas
- Controle de datas de entrada e saída
- Cálculo automático do valor da hospedagem
- Associação entre hóspedes e quartos

### 🔑 Check-in e Check-out
- Realização de check-in
- Realização de check-out
- Liberação automática do quarto após checkout

---

## 🏗️ Arquitetura

```text
Controller
    ↓
Service
    ↓
Repository
    ↓
Database
```

---

## 📂 Estrutura do Projeto

```text
hotel-system
│
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com.hotel
│   │   │       ├── controller
│   │   │       ├── dto
│   │   │       ├── entity
│   │   │       ├── repository
│   │   │       ├── service
│   │   │       └── HotelSystemApplication.java
│   │   │
│   │   └── resources
│   │       └── application.properties
│
├── pom.xml
└── README.md
```

---

## ⚙️ Tecnologias Utilizadas

- Java 21
- Spring Boot
- Spring Data JPA
- Hibernate
- MySQL
- Maven
- REST API

---

## 🚀 Configuração do Banco de Dados

```sql
CREATE DATABASE hotel_db;
```

## ▶️ Executando o Projeto

```bash
git clone https://gitlab.com/GuiOliver/hotel-system/
cd hotel-system
mvn clean install
mvn spring-boot:run
```

## 🧪 Melhorias Futuras

- Autenticação JWT
- Controle de usuários e permissões
- Swagger/OpenAPI
- Docker Compose
- Relatórios de ocupação
- Testes unitários e integração
- CI/CD no GitLab

## 👨‍💻 Autor

Guilherme Monção

## 📜 Licença

Projeto desenvolvido para fins de estudo, aprendizado e portfólio.