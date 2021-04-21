# Gestão Escolar 
[![NPM](https://img.shields.io/npm/l/react)](https://github.com/ariellopes94/gestao-escolar/blob/main/LICENSE) 

# Sobre o projeto

Sistema Escolar é uma API desenvolvida em Java e Spring Boot, construída para um  **Desafio de Programação**.


A pedagoga e empresária Paola Bucharelli está com novos planos de investimentos e
para isso decidiu que comprará a Escola Xavier para crianças com altas habilidades. Nessa escola,
os alunos serão matriculados em um de três cursos possíveis (exatas, humanas ou biológicas).
O aluno uma vez matriculado em um curso deverá realizar ao menos 3 disciplinas de sua
escolha. Para ser considerado aprovado no curso, o aluno deverá ter média final maior ou igual
a 7, sendo que o intervalo de notas é de 0 a 10.
Visando ter maior controle e monitorar a evolução dos alunos a Paola resolveu contratar
uma empresa de TI para desenvolver um sistema que lhe trouxesse as informações mais
relevantes de cada curso. Após uma cuidadosa procura ela encontrou a empresa ideal para a
construção dessa aplicação a “U-Can Inc.”, devido ao know-how e excelência na construção de
seus softwares.

![Mobile 1](https://github.com/ariellopes94/exemplo-readme/blob/main/imagem%20do%20Exemplo.png) 



## Documentação desenvolvida com Springdoc-openapi-ui
![Mobile 2](https://github.com/ariellopes94/exemplo-readme/blob/main/Sistema%20Escolar%20Documentacao%20gif.gif?raw=true)
https://teste-sistema-escolar.herokuapp.com/swagger-ui/index.html?configUrl=/v3/api-docs/swagger-config

## Teste de integração
Teste de integração é a fase do teste de software em que módulos são combinados e testados em grupo. 
Ela sucede o teste de unidade, em que os módulos são testados individualmente, e antecede o teste de
sistema, em que o sistema completo é testado num ambiente que simula o ambiente de produção.
![Web 1](https://github.com/ariellopes94/exemplo-readme/blob/main/teste%20de%20integra%C3%A7%C3%A3o.gif)


# Tecnologias utilizadas
## Back end
- Java 11
- Spring Boot
- JPA / Hibernate
- Maven
- H2 Database

## Implantação em produção
- Back end: Heroku

# Como executar o projeto

## Back end
Pré-requisitos: Java 11

```bash
# clonar repositório
git clone https://github.com/ariellopes94/gestao-escolar.git
# entrar na pasta do projeto back end
cd backend
# executar o projeto
./mvnw spring-boot:run
```
As dependências necessecarias do projeto serão baixada automaticamente,
o banco de dados em memoria H2, já esta configurado.


# Autor

Ariel Lopes de Souza

https://www.linkedin.com/in/ariel-lopes-de-souza-50321065/
