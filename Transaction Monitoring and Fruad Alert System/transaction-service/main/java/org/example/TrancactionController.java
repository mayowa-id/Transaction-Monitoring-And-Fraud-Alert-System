package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

    @RestController
    @RequestMapping("/api/transactions")
    public class TransactionController {

        private final TransactionService transactionService;

        @Autowired
        public TransactionController(TransactionService transactionService) {
            this.transactionService = transactionService;
        }

        @PostMapping
        public String processTransaction(@RequestBody Transaction transaction) {
            transactionService.sendTransaction(transaction);
            return "Transaction processed";
        }
    }


