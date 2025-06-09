# API de Gerenciamento de Teatro

Este projeto é uma API REST robusta para o gerenciamento de um sistema de teatros. Ele permite a gestão de teatros, salas, espetáculos, clientes, ingressos e pagamentos. A API é construída com Java e o framework Spring Boot, utilizando um banco de dados PostgreSQL para a persistência dos dados.

---

## Recursos

- **Gerenciamento de Teatros**: Crie e liste teatros.
- **Gerenciamento de Salas**: Crie e liste salas dentro de um teatro.
- **Gerenciamento de Áreas da Sala**: Defina e gerencie diferentes áreas dentro de uma sala (ex: VIP, Normal, Camarote).
- **Gerenciamento de Poltronas**: Gerencie as poltronas individuais de cada área da sala.
- **Gerenciamento de Espetáculos**: Crie, liste, atualize e delete espetáculos, incluindo agendamento e precificação.
- **Gerenciamento de Clientes**: Registre e gerencie clientes.
- **Gerenciamento de Ingressos**: Emita, consulte e gerencie ingressos para os espetáculos.
- **Gerenciamento de Pagamentos**: Processe e rastreie os pagamentos dos ingressos.
- **Documentação da API**: Documentação Swagger/OpenAPI integrada para fácil exploração e teste da API.

---

## Tecnologias Utilizadas

- Java 21  
- Spring Boot 3
- Spring Data JPA / Hibernate 
- PostgreSQL  
- Maven  
- Lombok  
- MapStruct  
- Springdoc OpenAPI / Swagger 

---

## 📄 Documentação Interativa com Swagger

Após rodar a aplicação, acesse:

```
http://localhost:8081/swagger-ui/index.html
```

![Swagger](https://github.com/Codee-Hub/theater_management_api/blob/main/src/imgs/Swagger.PNG)

---

## Schema do Banco de Dados

O schema do banco de dados foi projetado para suportar as funcionalidades de gerenciamento do teatro. Abaixo estão as tabelas principais e seus relacionamentos, conforme definido no arquivo `comandos-sql.txt`:

- **theater**: Armazena informações sobre os teatros.
- **room**: Contém detalhes sobre as salas de um teatro.
- **room_area**: Define as diferentes áreas dentro de uma sala.
- **armchair**: Representa as poltronas individuais em cada área da sala.
- **spectacle**: Guarda as informações sobre os espetáculos em cartaz.
- **client**: Armazena os dados dos clientes.
- **person_type**: Define diferentes tipos de pessoa para fins de precificação (ex: VIP, INTEIRA, MEIA).
- **ticket_price**: Gerencia os preços para os diferentes tipos de pessoa para cada espetáculo.
- **ticket**: Representa um ingresso comprado por um cliente para um espetáculo e poltrona específicos.
- **payment_method**: Armazena os métodos de pagamento disponíveis.
- **payment**: Contém os detalhes de pagamento para cada ingresso.

---

## Configuração e Instalação

### Pré-requisitos

- Java Development Kit (JDK) 21 ou superior  
- Apache Maven  
- PostgreSQL

### Configuração do Banco de Dados



Certifique-se de ter o PostgreSQL instalado e em execução.

1. Crie um novo banco de dados chamado `GestaoTeatro`.
2. Atualize as credenciais do banco de dados no arquivo `src/main/resources/application.properties` se forem diferentes do padrão:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/GestaoTeatro
spring.datasource.username=postgres
spring.datasource.password=postgres
```

## Executando a Aplicação

Clone o repositório:

```bash
git clone https://github.com/codee-hub/theater_management_api.git
cd theater_management_api
```

## 👨‍💻 Autor

Desenvolvido por [Kailan Dias (KailanDias)](https://github.com/KailanDias)  
---
