# 🛒 Sistema de Gerenciamento de Produtos – Mercado Angular + Spring Boot

**Um CRUD moderno de produtos para mercados, com interface dark, modais elegantes e toasts animados.**  
Permite **cadastrar, consultar, editar e excluir produtos**, com validações inteligentes de estoque e preço.
Ele se conecta à **API MercadoWeb** (backend em [Repositório da API MercadoWeb](https://github.com/Sambonha/mercadoWeb)) para gerenciamento de **Produtos**, consumindo os serviços disponíveis.

---

## ✨ Funcionalidades

- ✅ CRUD completo de produtos: **Adicionar, Consultar, Editar, Excluir**  
- ⚠️ Validações automáticas:  
  - Exclusão apenas se o estoque = 0  
  - Preço ≥ 0  
- 🔤 Conversão automática de **nome e categoria para maiúsculas**  
- 🌑 **Dark mode** com fundo cinza escuro  
- 📊 Lista de produtos responsiva, tabela animada  
- 🛎️ **Toasts animados** para feedback visual  
- 🖥️ Responsivo para desktop e mobile  
- 🔗 Integração completa com **back-end Spring Boot** via REST  

---

## 🛠 Tecnologias Utilizadas

| Camada | Tecnologia |
|--------|------------|
| Front-end | Angular 16, TypeScript, Bootstrap 5, Reactive Forms |
| Back-end  | Java, Spring Boot, Spring Data JPA, Hibernate, REST API |
| Banco de dados | H2 (configurável para MySQL/PostgreSQL) |
| Extras | Bootstrap Icons, Toasts animados |

---

## 📂 Estrutura do Projeto

frontend/
├── src/

│ ├── app/

│ │ ├── app.component.ts

│ │ ├── app.component.html

│ │ └── ...

backend/

├── src/main/java/br/com/cotiinformatica/

│ ├── controllers/

│ ├── services/

│ ├── repositories/

│ └── entities/


---

## 🚀 Como Executar

### Back-end
1. Configure o banco de dados em `application.properties` ou use H2 padrão.  
2. Execute a aplicação Spring Boot (`ProdutosApplication.java`).  

### Front-end
1. Navegue até a pasta `frontend`.  
2. Instale dependências:
`bash
npm install
Execute a aplicação Angular:
ng serve`

Abra no navegador:
http://localhost:4200

| Método | Endpoint                        | Descrição                     |
| ------ | ------------------------------- | ----------------------------- |
| POST   | /api/v1/produtos/criar          | Criar produto                 |
| PUT    | /api/v1/produtos/atualizar/{id} | Atualizar produto             |
| DELETE | /api/v1/produtos/excluir/{id}   | Excluir produto (estoque = 0) |
| GET    | /api/v1/produtos/consultar      | Consultar todos produtos      |






