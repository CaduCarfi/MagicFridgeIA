# 🧊 MagicFridgeAI

API REST em Spring Boot que gerencia os alimentos da sua geladeira e sugere receitas personalizadas usando Inteligência Artificial, com base nos itens que você já tem em casa.

## 📋 Sobre o Projeto

O MagicFridgeAI ajuda a evitar desperdício de alimentos e facilita o dia a dia na cozinha: você cadastra os itens disponíveis na sua geladeira (nome, categoria, quantidade e validade) e a aplicação gera sugestões de receitas usando IA, aproveitando o que você já possui.

## ✨ Funcionalidades

- 🥕 Cadastro, listagem, atualização e remoção de itens da geladeira (`FoodItem`)
- 🤖 Geração de receitas com IA a partir dos alimentos cadastrados
- 🗄️ Persistência de dados com PostgreSQL
- 🔄 Versionamento de banco de dados com Flyway

## 🛠️ Tecnologias

- **Java 21**
- **Spring Boot 4.1**
  - Spring Data JPA
  - Spring WebFlux / WebClient
  - Spring Boot Flyway
- **PostgreSQL**
- **Docker / Docker Compose**
- **Lombok**
- **dotenv-java** — carregamento de variáveis de ambiente
- **API de IA** (OpenAI-compatible) — geração de receitas

## 📁 Estrutura do Projeto

```
src/main/java/dev/java10x/MagicFridgeAI
├── config          # Configurações (WebClient, Dotenv)
├── controller       # Endpoints REST
├── enums            # Enumeradores do domínio
├── model             # Entidades JPA
├── repository        # Repositórios (Spring Data JPA)
├── service            # Regras de negócio e integração com IA
└── MagicFridgeAiApplication.java
```

## 🚀 Como Rodar o Projeto

### Pré-requisitos

- Java 21+
- Maven
- Docker e Docker Compose

### Passo a Passo

1. **Clone o repositório**
   ```bash
   git clone https://github.com/CaduCarfi/MagicFridgeIA.git
   cd MagicFridgeIA
   ```

2. **Configure as variáveis de ambiente**

   Crie um arquivo `.env` na raiz do projeto:
   ```properties
   API_KEY=sua_chave_da_api_aqui
   ```

3. **Suba o banco de dados**
   ```bash
   docker-compose up -d
   ```

4. **Rode a aplicação**
   ```bash
   mvn spring-boot:run
   ```

5. **Acesse a API**

   A aplicação estará disponível em `http://localhost:8080`

## 📡 Principais Endpoints

| Método | Rota | Descrição |
|---|---|---|
| `GET` | `/foodItems` | Lista os itens cadastrados |
| `POST` | `/foodItems` | Cadastra um novo item |
| `GET` | `/generate` | Gera uma receita com base nos itens cadastrados |

## 🔒 Segurança

Este projeto utiliza variáveis de ambiente para proteger dados sensíveis (como chaves de API). O arquivo `.env` **não é versionado** e está incluído no `.gitignore`.

## 📄 Licença

Este projeto está sob a licença MIT. Sinta-se livre para usar, estudar e contribuir.

---

Desenvolvido como projeto de estudo para aprender integração com APIs de IA em aplicações Spring Boot. 🚀
