API Gateway - Arquitetura de Microsserviços 

Este repositório contém um projeto de arquitetura de microserviços utilizando o Spring Boot, incluindo um API Gateway para centralizar as requisições. O projeto foi desenvolvido como parte de um estudo para aplicar conceitos de microsserviços, API Gateway e Spring Cloud Gateway. O sistema é composto pelos seguintes serviços:

API Gateway: 🔀 Roteamento das requisições para os serviços específicos.

Cliente Service: 👥 Gerencia operações relacionadas a clientes.

Pedido Service: 🛒 Gerencia operações de pedidos.

Objetivo do Estudo 📚
O objetivo principal deste estudo foi entender e implementar a arquitetura de microsserviços com o Spring Boot, destacando as melhores práticas para desenvolvimento, deploy e escalabilidade de sistemas. Durante o desenvolvimento, foi aplicada a utilização de API Gateway para centralizar o acesso aos microsserviços, além de testar integração contínua (CI/CD), containerização via Docker e a documentação automática da API com Springdoc OpenAPI.

## Estrutura do Projeto 📂

O projeto é dividido nas seguintes pastas:

├── APIGateway/ # API Gateway para roteamento e controle de tráfego
├── cliente-service/ # Serviço de gerenciamento de clientes
├── pedido-service/ # Serviço de gerenciamento de pedidos
├── Dockerfile # Dockerfile para empacotar o projeto
├── .gitignore # Arquivo para ignorar arquivos temporários e dependências
├── README.md # Este arquivo
<img width="1231" height="405" alt="image" src="https://github.com/user-attachments/assets/c4d50a14-947b-4bb0-a9cc-3f004ab25de9" />
Configuração do Spring Cloud Gateway usado para rotear requisições HTTP entre diferentes microsserviços. A configuração especifica as rotas que o API Gateway irá seguir para encaminhar as requisições para os serviços corretos.
<img width="1920" height="496" alt="image" src="https://github.com/user-attachments/assets/010f9596-7a84-4eb0-a5b4-1d43ba500ca6" />

![Testes Integrados 1](https://github.com/user-attachments/assets/26447641-6a42-401c-8d85-fa54b1b48848)
![Testes Integrados 2](https://github.com/user-attachments/assets/3318fd41-f024-4837-959a-73d4d3b17407)

## Testes Integrados 🔍

<img width="1920" height="828" alt="image" src="https://github.com/user-attachments/assets/894e31e0-d321-462b-9ff4-4b876545e470" />

### Testes Usando o Insomnia 📡
GET: http://localhost:8080/clientes
Requisição:
json
{
  "nome": "Teste3",
  "email": "teste3@exemplo.com"

Resposta:
<img width="1145" height="462" alt="image" src="https://github.com/user-attachments/assets/af0b9ccc-ea44-4cd4-9d43-cbf8fae9b953" />





Redução de Preço 💲
Descrição do processo de redução de preço aqui...

Tecnologias Utilizadas 🛠️
Spring Boot: Framework para desenvolvimento de aplicações Java.

Spring Cloud Gateway: Para gerenciar e rotear as requisições de API.

Spring Data JPA: Para interação com bancos de dados relacionais.

H2 Database: Banco de dados em memória para testes.

Docker: Para containerização e deployment das aplicações.

GitHub Actions: Para CI/CD (integração contínua e deploy contínuo).

Como Rodar Localmente 🖥️
Clone o repositório:


git clone https://github.com/lucasleao-dev/api-gateway-client-pedido.git
cd api-gateway-client-pedido
Compilar e rodar os microserviços com Maven:

Para rodar cada serviço (API Gateway, Cliente Service, Pedido Service), acesse a respectiva pasta e execute:


mvn clean install
mvn spring-boot:run
Gateway de API :

Acesse o API Gateway por:


http://localhost:8080/clientes
http://localhost:8080/pedidos
Docker 🐳
Se você preferir rodar os serviços usando Docker, use o seguinte comando para construir a imagem e rodar o contêiner:


docker build -t api-gateway .
docker run -p 8080:8080 api-gateway
Dockerfile 📄
O projeto contém um Dockerfile que empacota a aplicação em um contêiner. Certifique-se de que o JAR da aplicação está na pasta target/ antes de rodar os comandos acima.

Documentação da API 📚
O projeto usa Springdoc OpenAPI para gerar documentação de API automaticamente.

Acesse a documentação Swagger em:

http://localhost:8080/swagger-ui.html
Testículos 🔍
Os testes integrados para os serviços de cliente e pedido estão localizados nas pastas src/test/java.

Testes de Integração ⚙️
O projeto já inclui testes de integração para garantir que os endpoints estão funcionando corretamente.

