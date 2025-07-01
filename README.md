---

# Sistema de Gestão de Vagas e Empresas

Sistema backend desenvolvido em **Spring Boot** para gerenciamento de vagas de emprego e empresas associadas. Permite cadastro, consulta e relacionamento entre vagas e empresas, com tratamento de erros e validação.

---

## Funcionalidades

* Cadastro de empresas (nome, usuário, email, site, descrição, etc)
* Cadastro de vagas associadas a empresas
* Associação entre vagas e empresas
* Tratamento de erros personalizado
* API RESTful para operações CRUD básicas

---

## Tecnologias

* Java 17+
* Docker (opcional)
* Spring Boot 3.2.5
* Spring Data JPA / Hibernate
* Banco de dados relacional (PostgreSQL, MySQL, etc)
* Lombok
* Jakarta Validation
* Spring Security com JWT
* Springdoc OpenAPI (Swagger UI)
* Maven / Gradle

---

## Como executar

1. Clone o repositório:

```bash
git clone https://github.com/seuusuario/seu-projeto.git
cd seu-projeto
```

2. Configure seu banco de dados e ajuste o arquivo `application.properties` (ou `application.yml`) com suas credenciais.

3. Para rodar localmente:

```bash
./mvnw clean spring-boot:run
```

Ou, se preferir via Docker (se tiver Dockerfile):

```bash
docker build -t gestao_vagas .
docker run -p 8080:8080 gestao_vagas
```

4. Acesse a API e a documentação Swagger:

* API base URL: `http://localhost:8080`
* Documentação OpenAPI JSON: `http://localhost:8080/v3/api-docs`
* Swagger UI interativo: `http://localhost:8080/swagger-ui/index.html`

---

## Endpoints principais

| Método | Endpoint        | Descrição                           |
| ------ | --------------- | ----------------------------------- |
| POST   | `/empresa/`     | Criar nova empresa                  |
| POST   | `/vagas/`       | Criar nova vaga associada à empresa |
| POST   | `/candidato/`   | Criar novo candidato                |
| POST   | `/auth/empresa` | Autenticação da empresa (login)     |

---

## Estruturas principais (Schemas)

* **EmpresaEntity** — dados da empresa (nome, usuário, email, senha, site, descrição)
* **VagasEntity** — dados da vaga (descrição, nível, benefícios, empresa vinculada)
* **CriarVagasDTO** — DTO para criação de vagas via API
* **CandidatoEntity** — dados do candidato
* **AuthEmpresaDTO** — dados para login da empresa

