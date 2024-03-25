package com.poc.investor.repositories;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.jpa.repository.JpaRepository;
import com.poc.investor.models.entities.Investor;
@RepositoryRestResource
public interface InvestorRepository extends JpaRepository<Investor, Integer> {
}
