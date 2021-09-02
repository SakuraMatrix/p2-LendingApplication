# p2-LendingApplication
## Project Description
Peer to peer lending application that connects borrowers to lenders.
## Technologies Used
* GitHub Monorepo
* Agile SDLC:
  * Scrumboard (GitHub Projects)
  * User stories (GitHub Issues/Readme)
* Java 11+
* Maven
* Spring Boot
* Karate tests
* Reactive Microservices:
  * Spring WebFlux
  * Spring Data Reactive Cassandra
  * Spring WebClient
* Spring Cloud modules:
  * Spring Cloud Gateway
  * Spring Cloud Eureka/Discovery
* AWS Keyspaces
## Features 
* Lenders can create an account 
* Lenders can access all their transactions 
* Lenders can update information no their account
* Borrowers can create an account
* Borrowers can create new loan applications
* Borrowers can access all their transactions
## Getting Started
To start clone the repository:

`git clone https://github.com/SakuraMatrix/p2-LendingApplication.git`
## Usage
### Run Services
Every folder in the p2-LendingApplication repository is a micro service. Each micro service is a Spring Boot application and can started locally using the following command inside the service folder:

`mvn spring-boot:run`

Please note that infrastructure micro services (Eureka-discovery-service and gateway-service) must be started before any other services (transaction, lender, and borrower)
If everything goes well, you will be able to access the following services at these locations:
* Discovery Service - http://localhost:8761
* Gateway Service - http://localhost:8080
* Transaction, Lender and Borrower services - random port, check Eureka Dashboard
## Contributors
* [Jesus Esquer](https://github.com/jm27)
* [Chris Jose](https://github.com/christopherjose)
* [Olenka Quispe Huanca](https://github.com/Olenkaqh)
