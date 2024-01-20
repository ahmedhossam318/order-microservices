# Order Microservices with Kafka

## Overview
This project demonstrates a microservices-based order management system using Kafka for messaging and event-driven communication. It's designed to showcase the interaction between different services in a microservice architecture, focusing on order processing, rewards, and promotions.

## Services
- **kafka-order**: Manages the core order processing logic including handling orders, discounts, and promotions. It also includes Kafka producers and consumers for message handling.
- **kafka-pattern**: Demonstrates various Kafka usage patterns, particularly focusing on consuming order messages.
- **kafka-reward**: Handles reward logic associated with orders. It processes order messages and generates rewards.
- **kafka-storage**: Responsible for storing or caching data related to promotions, handling promotion-related messages.

## Technologies
- Java with Spring Boot
- Apache Kafka for messaging
- Maven for dependency management
- Docker for containerization

## Getting Started
To run this project locally, you'll need Docker, Maven, and Kafka installed on your machine. Follow these steps:

1. Clone the repository:
 git clone https://github.com/ahmedhossam318/order-microservices.git

2. Navigate to the docker directory:
 docker-compose up


## API Endpoints
## API Endpoints

### kafka-order Service
- **Create Order**
  - **Endpoint**: `/api/order`
  - **Method**: POST
  - **Request**: Includes order details such as items, quantities, and customer information.
  - **Response**: Confirmation of the order creation with an order ID.

- **Apply Discount**
  - **Endpoint**: `/api/discount`
  - **Method**: POST
  - **Request**: Discount details including order ID and discount rate.
  - **Response**: Updated order with the applied discount.

- **Promotions**
  - **Endpoint**: `/api/promotion`
  - **Method**: POST
  - **Request**: Details about the promotion to be applied.
  - **Response**: Confirmation of the promotion application.

### kafka-pattern Service


### kafka-reward Service
- **Order Rewards**
  - **Endpoint**: `/api/rewards`
  - **Method**: GET/POST (as applicable)
  - **Request**: Order ID or customer details.
  - **Response**: Details of the rewards earned for the specified order.

### kafka-storage Service

## Testing
You can test the API endpoints using the provided Postman collection:
- `Order_microservices.postman_collection.json`

## Contributing
Contributions to the project are welcome! Please follow the standard process:
1. Fork the repository.
2. Create a new branch: `git checkout -b your-branch-name`.
3. Make your changes and commit them: `git commit -m 'commit message'`.
4. Push to the original branch: `git push origin your-branch-name`.
5. Create a pull request.


## Contact
For any queries, feel free to contact us.
 
