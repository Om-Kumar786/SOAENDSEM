package com.example.klu;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.klu.BankAccount;
import com.example.klu.BankService;

@RestController
@RequestMapping("/bank")
public class BankController {

    private final BankService service;

    public BankController(BankService service) {
        this.service = service;
    }

    @PostMapping("/create")
    public BankAccount create(@RequestBody BankAccount account) {
        return service.create(account);
    }

    @GetMapping("/all")
    public List<BankAccount> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public BankAccount getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PutMapping("/deposit/{id}")
    public BankAccount deposit(
            @PathVariable Long id,
            @RequestParam double amount) {
        return service.deposit(id, amount);
    }

    @PutMapping("/withdraw/{id}")
    public BankAccount withdraw(
            @PathVariable Long id,
            @RequestParam double amount) {
        return service.withdraw(id, amount);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "Account deleted successfully";
    }
}