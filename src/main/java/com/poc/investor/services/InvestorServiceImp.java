package com.poc.investor.services;

import com.poc.investor.models.entities.Investor;
import com.poc.investor.repositories.InvestorRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class InvestorServiceImp implements InvestorService {

    private InvestorRepository investorRepository;

    @Override
    public List<Investor> findAll() {
        return investorRepository.findAll();
    }


    @Override
    public Investor save(Investor investor) {
        return investorRepository.save(investor);
    }
}
