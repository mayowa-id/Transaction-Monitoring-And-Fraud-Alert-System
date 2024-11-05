package org.example;
import com.example.rabbitmqconfig.RabbitMQConfig;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

    @Service
    public class FraudDetectionService {

        private final RabbitTemplate rabbitTemplate;

        @Autowired
        public FraudDetectionService(RabbitTemplate rabbitTemplate) {
            this.rabbitTemplate = rabbitTemplate;
        }

        @RabbitListener(queues = RabbitMQConfig.TRANSACTION_QUEUE)
        public void receiveTransaction(Transaction transaction) {
            if (isFraudulent(transaction)) {
                rabbitTemplate.convertAndSend(RabbitMQConfig.FRAUD_ALERT_QUEUE, "Fraudulent transaction detected!");
            }
        }

        private boolean isFraudulent(Transaction transaction) {
            // Simple logic for demo purposes, e.g., high amount threshold.
            return transaction.getAmount() > 10000;
        }
    }


