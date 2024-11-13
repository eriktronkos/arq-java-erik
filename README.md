# Projeto Final Arquitetura Java [24E4_2] - Cadastro de Empresas, Titulos e Stakeholders

<!-- TOC -->
* [Projeto Final Arquitetura Java [24E4_2] - Cadastro de Empresas, Titulos e Stakeholders](#projeto-final-arquitetura-java-24e4_2---cadastro-de-empresas-titulos-e-stakeholders)
  * [Autor](#autor)
  * [Contexto do projeto](#contexto-do-projeto)
  * [Início rápido](#início-rápido)
    * [Requisitos](#requisitos-)
    * [Instalação](#instalação-)
    * [Executando o Projeto](#executando-o-projeto-)
    * [Construindo o Projeto](#construindo-o-projeto-)
    * [Documentação](#documentação-)
<!-- TOC -->

## Autor

- **Erik Tronkos** - br.edu.infnet

## Contexto do projeto
Para este projeto foi utilizado com contexto de governança empresarial. Neste contexto teremos **empresas** que emitem diferentes **títulos** (**Ações**, **Opções**) para seus **stakeholders** (sócios).

## Início rápido

Este é um projeto Spring Boot configurado para Java 17 e gerenciado com Maven. 
Siga as instruções abaixo para configurar e executar o projeto. 

### Requisitos 

- **Java 17**: Certifique-se de ter o Java Development Kit (JDK) 17 instalado. Você pode verificar sua versão com o comando:
```bash
java -version
``` 
 
- **Maven**: O Maven é usado para gerenciar as dependências e construir o projeto. Verifique se está instalado com o comando:
```bash
mvn -v
``` 

### Instalação  
1. **Clone o Repositório**
```bash
git clone https://github.com/eriktronkos/arq-java-erik.git && cd arq-java-erik
```
2. **Instale as Dependências** 
Execute o seguinte comando para baixar as dependências do projeto e construir o artefato: 
  ```bash
  mvn clean install
  ``` 

### Executando o Projeto 

- Para executar o projeto localmente, utilize o comando: 
```bash
mvn spring-boot:run
```
 A aplicação estará disponível em http://localhost:8080, a menos que outra porta seja configurada.
 
### Construindo o Projeto 

- Para construir o projeto e gerar um arquivo JAR executável, use: 
```bash
mvn clean package
```
O JAR gerado estará localizado na pasta `target/`. 

### Documentação 
- Para acessar a documentação das APIs geradas pelo Swagger, acesse: http://localhost:8080/swagger-ui.html
- Para acessar a documentação das APIs pelo Postman, importe o arquivo `gestao-de-titulos.postman_collection.json` na raíz do projeto para dentro do seu Postman



