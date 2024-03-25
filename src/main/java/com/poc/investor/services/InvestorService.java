package com.poc.investor.services;

import com.poc.investor.models.entities.Investor;
import com.poc.investor.repositories.InvestorRepository;

import java.util.List;

public interface InvestorService  {
    Investor save(Investor investor);
    List<Investor> findAll();
}
