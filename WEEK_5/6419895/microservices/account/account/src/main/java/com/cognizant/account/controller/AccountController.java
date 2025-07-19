package com.cognizant.account.controller;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    @GetMapping("/{number}")
    public Map<String, Object> getAccountDetails(@PathVariable String number) {
        Map<String, Object> accountDetails = new HashMap<>();
        accountDetails.put("accountNumber", number);
        accountDetails.put("accountHolder", "Ravi Kumar");
        accountDetails.put("accountType", "Savings");
        accountDetails.put("balance", 234343.75);
        accountDetails.put("currency", "INR");
        accountDetails.put("branch", "Pune Main Branch");

        return accountDetails;
    }
}
