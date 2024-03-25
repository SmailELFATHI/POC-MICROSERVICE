package com.poc.investor.controllers;

import com.poc.investor.models.entities.Investor;
import com.poc.investor.services.InvestorService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class InvestorController {

    private InvestorService investorService;

    @GetMapping("/investors")
    public List<Investor> investor() {
        return investorService.findAll();
    }
}
