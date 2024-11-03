# Transaction-Monitoring-And-Fraud-Alert-System

This project is a couple of microservices that function as a fraud detection system. 
RabbitMQ will be used  for communication. Basically I created two microservices:
1. Transaction Service : It accepts incoming transactions.
2. Fraud Detection Service : Monitores transactions for potentially fraudulent activity.


PROJECT STRUCTURE 
fraud-detection-system/
├── rabbitmq-config/ 
        └── RabbitMQConfig.java # RabbitMQ queues and config  
├── transaction-service/ 
        ├── TransactionService.java # Service to send transactions to fraud detection  
        ├── TransactionController.java # REST controller for transaction submission 
└── model/ │ 
        └── Transaction.java # Model representing a transaction (used for deserialization)  
├── fraud-detection-service/ 
        ├── FraudDetectionService.java # Service to check for fraudulent transactions 

└── README.md # Documentation


Technologies Used 
- Java
- Springboot
- RabbitMQ for asynchronous messaging
- Docker (optional) for containerizing RabbitMQ

How It Works
- Transaction Submission: The transaction service API  accepts tramsaction
  details, which are sent to RabbitMQ's transaction_queue.
- Fraud Detection: The fraud detection service consumes transactions from the transaction_queue.
- If a transactionis flagged as fraudulent, it sends a message to fraud_alert_queue

MODULES & CODE EXPLANATION
1. RabbitMQ Configuration (rabbitmq-config)
   The RabbitMQConfig class is used to set up two RabbitMQ queues for message exchange:
   - transaction_queue: Receives messages from TransactionService class.
   - fraud_alerlt_queue: Receives fraud alerts from FraudDetectionService class.
  

2. Transaction Service (transaction-service)
   The Transaction Service accepts incoming transactions through a REST API and sends
   them to the transaction_queue for fraud detection processing.
     - TransactionService: A service class that sends transactions to thte RavvitMQ queue.
     - TransactionController: REST controller that provides an endpoint  to receive transaction
     - data.
     - Transacion Model: Represents transaction details (e.g transaction id and transaction amount)

3. Fraud Detection Service (fraud-detection-service)
   The Fraud Detection Service listens to the transaction_queue for transactions and processes them.
   If a transaction meets fraud criteria (e.g exceeding a certain amount), it generates a fraud alert
   in the fraud_alert_queue.


RUNNING THE APPLICATION
1. Clone the repo
2. Start RabbitMQ, ensure RabbitMQ is running.
3. Build and run each service (transaction-service and fraud-detection-service)
4. and execute ./mvnw spring-boot:run 
5. Testing the Application: Use the following command to send a transaction to the Transaction
   service API

curl -X POST http://localhost:8080/api/transactions -H "Content-Type: application/json" -d '{"id": "1", "amount": 15000}'

