# Reactive Management System

This project is a reactive management system application built with Spring Boot, using a service and repository-based architecture. It includes functionalities for managing both beers and customers.

## Features

- **Reactive CRUD**: Create, read, update, and delete beers and customers in a reactive manner.
- **MapStruct**: Mapping between entities and DTOs.
- **Spring Data R2DBC**: Reactive repositories for data access.
- **Validation**: Input data validation using \`jakarta.validation\`.

## Requirements

- Java 17 or higher
- Maven 3.6.0 or higher
- R2DBC-compatible database (e.g., PostgreSQL)

## Installation

1. Clone the repository:
    \`\`\`sh
    git clone https://github.com/your-username/reactive-management-system.git
    cd reactive-management-system
    \`\`\`

2. Configure the database in the \`application.properties\` file:
    \`\`\`properties
    spring.r2dbc.url=r2dbc:postgresql://localhost:5432/your_database
    spring.r2dbc.username=your_username
    spring.r2dbc.password=your_password
    \`\`\`

3. Build and run the application:
    \`\`\`sh
    mvn clean install
    mvn spring-boot:run
    \`\`\`

## Usage

The application exposes several REST endpoints for managing beers and customers. Below are some of the available endpoints:

### Customer Endpoints

- **List all customers**: \`GET /api/v2/customer\`
- **Get a customer by ID**: \`GET /api/v2/customer/{customerId}\`
- **Create a new customer**: \`POST /api/v2/customer\`
- **Update an existing customer**: \`PUT /api/v2/customer/{customerId}\`
- **Patch an existing customer**: \`PATCH /api/v2/customer/{customerId}\`
- **Delete a customer**: \`DELETE /api/v2/customer/{customerId}\`

### Beer Endpoints

- **List all beers**: \`GET /api/v2/beer\`
- **Get a beer by ID**: \`GET /api/v2/beer/{beerId}\`
- **Create a new beer**: \`POST /api/v2/beer\`
- **Update an existing beer**: \`PUT /api/v2/beer/{beerId}\`
- **Patch an existing beer**: \`PATCH /api/v2/beer/{beerId}\`
- **Delete a beer**: \`DELETE /api/v2/beer/{beerId}\`

## Contribution

Contributions are welcome! If you wish to contribute, please follow these steps:

1. Fork the project.
2. Create a new branch (\`git checkout -b feature/new-feature\`).
3. Make your changes and commit them (\`git commit -am 'Add new feature'\`).
4. Push your changes to your fork (\`git push origin feature/new-feature\`).
5. Open a Pull Request.

## License

This project is licensed under the MIT License. See the \`LICENSE\` file for more details.
