package com.example.klu;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.klu.BankAccount;

public interface BankRepository
        extends JpaRepository<BankAccount, Long> {
}