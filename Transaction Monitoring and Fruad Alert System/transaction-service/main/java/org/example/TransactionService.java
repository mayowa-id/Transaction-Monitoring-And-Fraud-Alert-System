package org.example;
import com.example.rabbitmqconfig.RabbitMQConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

    @Service
    public class TransactionService {

        private final RabbitTemplate rabbitTemplate;

        @Autowired
        public TransactionService(RabbitTemplate rabbitTemplate) {
            this.rabbitTemplate = rabbitTemplate;
        }

        public void sendTransaction(Transaction transaction) {
            rabbitTemplate.convertAndSend(RabbitMQConfig.TRANSACTION_QUEUE, transaction);
        }
    }
