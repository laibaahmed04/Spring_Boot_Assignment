
package com.redmath.bank.Transaction;
import com.redmath.bank.Balance.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {
    private final TransactionRepository repository;
   private final BalanceService balance_service;
    TransactionService(TransactionRepository repository ,BalanceService balance_service){
        this.repository=repository;
        this.balance_service=balance_service;

    }
    public Transaction create_transaction(Transaction transaction , Long id) {
        if (transaction.getTransactionId() != null && repository.existsById(transaction.getTransactionId())) {
            return null;

        }

        balance_service.Update_Balance(id, transaction.getAmount());
        return repository.save(transaction);

    }

    public List<Transaction> find_All()
    {
        return repository.findAll();
    }

}
