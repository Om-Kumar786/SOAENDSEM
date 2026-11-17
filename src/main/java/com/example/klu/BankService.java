package com.example.klu;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.klu.BankAccount;
import com.example.klu.BankRepository;

@Service
public class BankService {

    private final BankRepository repo;

    public BankService(BankRepository repo) {
        this.repo = repo;
    }

    public BankAccount create(BankAccount account) {
        return repo.save(account);
    }

    public List<BankAccount> getAll() {
        return repo.findAll();
    }

    public BankAccount getById(Long id) {
        return repo.findById(id)
                .orElseThrow(() ->
                    new RuntimeException("Account not found"));
    }

    public BankAccount deposit(Long id, double amount) {
        if (amount <= 0)
            throw new RuntimeException("Invalid amount");

        BankAccount account = getById(id);
        account.setBalance(account.getBalance() + amount);

        return repo.save(account);
    }

    public BankAccount withdraw(Long id, double amount) {
        BankAccount account = getById(id);

        if (amount <= 0 || amount > account.getBalance())
            throw new RuntimeException("Insufficient balance or invalid amount");

        account.setBalance(account.getBalance() - amount);

        return repo.save(account);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}