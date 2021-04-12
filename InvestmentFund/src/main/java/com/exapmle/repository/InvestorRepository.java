package com.exapmle.repository;

import com.exapmle.entity.Investor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvestorRepository extends JpaRepository<Investor, Long> {
   Investor findByUsername(String username);
}
