package org.example;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

    @Configuration
    public class RabbitMQConfig {

        public static final String TRANSACTION_QUEUE = "transaction_queue";
        public static final String FRAUD_ALERT_QUEUE = "fraud_alert_queue";

        @Bean
        public Queue transactionQueue() {
            return new Queue(TRANSACTION_QUEUE, true);
        }

        @Bean
        public Queue fraudAlertQueue() {
            return new Queue(FRAUD_ALERT_QUEUE, true);
        }
    }

}
