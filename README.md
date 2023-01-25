
## CQRS Spring Boot Project

This project is a demonstration of the Command-Query Responsibility Segregation (CQRS) pattern using Spring Boot.

**Getting Started**

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

**Prerequisites**

 - Java 8 or later 
 - Maven 3.6.0 or later

**Installation**

- Clone the repository: git clone https://github.com/mmendespro/spring-cqrs-poc.git
- Navigate to the project directory: cd cqrs-spring-boot
- Build the project: mvn clean install
- Run the project: mvn spring-boot:run

**Project Structure**

The project is divided into two main components:
 - Command Side: Responsible for handling command requests and updating the state of the system.
 - Query Side: Responsible for handling query requests and providing a read-only view of the system's state.

**Built With**
- Spring Boot - The web framework used
- Maven - Dependency Management