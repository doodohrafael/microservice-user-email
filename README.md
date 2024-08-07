# Microservices User Email

## Tecnologias utilizadas:
Microservices com Java 21, Spring Boot, Spring Data JPA, Spring AMQP, Spring Validation, Lombok, MySql, Spring Rabbit, Spring Web, Maven.

## Descrição:
Dois microservices independentes que se comunicam através de mensagens com ajuda do message broker HabbitMQ. Comunicação assíncrona por comandos.
FLuxo: Assim que um usuário é cadastrado no banco, uma messagem é enviada para o exange que delega pra queue (fila). O microservice email escuta a mensagem e recebe a mesma e o corpo com dados em seguida faz o envio da mensagem para o email do usuário cadastrado e salva o email no banco. 
