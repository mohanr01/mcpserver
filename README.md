# MCP Server

A Spring Boot-based Math Calculation Protocol (MCP) server that exposes mathematical operations as HTTP endpoints and provides a tool discovery API.

## Features
- Exposes math operations (add, multiply, divide) as REST endpoints
- Tool discovery endpoint to list all available MCP tools
- Example static web client for interacting with the server
- Easily extensible for new math or custom tools

## Endpoints

### Math Operations
- `GET /application/v1/add?a=5&b=8` — Returns the sum of two numbers
- `GET /application/v1/tools` — Lists all available MCP tools with metadata

### Example Response for `/application/v1/tools`
```json
[
  {
    "bean": "MathService",
    "method": "add",
    "name": "add",
    "description": "sum of two number"
  },
  ...
]
```

## Running the Server

1. Build the project:
   ```sh
   mvn clean install
   ```
2. Run the server:
   ```sh
   mvn spring-boot:run
   ```
   The server will start on port 8000 by default (or as configured in `application.properties`).

## Using the Web Client
- Open `src/main/webapp/static/Autoload.html` in your browser.
- Click the button to fetch and display available MCP tools from the server.

## Project Structure
- `src/main/java/com/app/service/MathService.java` — Math operations as MCP tools
- `src/main/java/com/app/web/MathController.java` — REST controller for math endpoints
- `src/main/java/com/app/web/ToolController.java` — REST controller for tool discovery
- `src/main/webapp/static/client.js` — Example JavaScript client

## Requirements
- Java 17+
- Maven 3.6+
- Spring Boot 3.x

## License
MIT License