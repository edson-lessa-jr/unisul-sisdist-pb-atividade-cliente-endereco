# Atividade Micro-serviços
## Objetivo
Criar uma arquitetura de microservices em que uma api possa consumir os serviços de outra.
Os serviços deverão utilizar o eureka como service-discovery para se auto registrar.
Os serviços utilizarão o config-server para consumir os dados de configuração com banco de dados

## Problema
Relizar o registro de cliente com seu respectivo endereço.
Listar todos os clientes cadastrados.
Possibilitar o cadastro de novos endereços
Possibilitar listar todos os endereços
Possibilitar consultar o endereço por CEP. (Considerar um CEP por registro)

## Prazo
A Atividade deverá ser desenvolvida na sala de aula as 2º
Data de apresentação 18/10. 

### Informações adicionais
* As classes concretas já estão definidas
* A classe Endereco já se encontra Annotada com JPA
* As dependências já estão configuradas, MENOS O BANCO DE DADOS
* O banco de dados é de sua escolha
* O config-server e eureka-serve estão criados sem configuração (necessário configurar)
* No projeto ms-cliente e ms-endereco existe uma pasta chamada modelo-servico que contem dois arquivos json como modelo para exemplo de listagem e inserção
  * **Obrigatóriamente devem ser seguidos**
* Deverá ser desenvolvido 
1. Os endpoints necessários
2. As consultas necessárias
3. Os DTOs necessários
4. Consumir os serivços que forem necessários
