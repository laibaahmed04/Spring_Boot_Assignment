package com.redmath.bank.Transaction;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/bank/transaction")
public class TransactionController {

    private final TransactionService service;


    TransactionController(TransactionService service){
        this.service=service;
    }
    @GetMapping
    public ResponseEntity<List<Transaction>> find_all_accounts(){

        return ResponseEntity.ok(service.find_All());
    }

   @PostMapping()
    public ResponseEntity<Transaction> perform_transaction(@RequestBody Transaction transaction)
    {
transaction.setDate(new Date());
System.out.println(transaction.getTransactionId());
        System.out.println(transaction.getAccount_ID());

        System.out.println(transaction.getIndicator());

        System.out.println(transaction.getAmount());

        System.out.println(transaction.getDate());

        Transaction transaction_created = service.create_transaction(transaction,transaction.getAccount_ID());

        if(transaction_created!=null){
            return ResponseEntity.ok(transaction_created);
        }

        else{
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }







    }









}
