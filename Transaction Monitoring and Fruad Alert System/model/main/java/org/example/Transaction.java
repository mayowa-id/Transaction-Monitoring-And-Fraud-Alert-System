package org.example;

import java.io.Serializable;

    public class Transaction implements Serializable {
        public Transaction(String id, double amount) {
            this.id = id;
            this.amount = amount;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public double getAmount() {
            return amount;
        }

        public void setAmount(double amount) {
            this.amount = amount;
        }

        private String id;
        private double amount;

    }


