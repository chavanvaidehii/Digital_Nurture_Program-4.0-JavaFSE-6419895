package com.cognizant.loan.controller;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/loans")
public class LoanController {

    @GetMapping("/{number}")
    public Map<String, Object> getLoanDetails(@PathVariable String number) {
        Map<String, Object> loanDetails = new HashMap<>();
        loanDetails.put("loanAccountNumber", number);
        loanDetails.put("type", "Car Loan");
        loanDetails.put("loanAmount", 400000);
        loanDetails.put("emi", 3258);
        loanDetails.put("tenureMonths", 18);
        loanDetails.put("interestRate", 8.5);
        loanDetails.put("borrowerName", "Harshika Chavan");
        loanDetails.put("branch", "Mumbai Central Branch");
        loanDetails.put("approvedDate", "2023-02-15");
        loanDetails.put("status", "Active");

        return loanDetails;
    }
}
