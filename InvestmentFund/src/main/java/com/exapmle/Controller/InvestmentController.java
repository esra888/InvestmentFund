package com.exapmle.Controller;

import com.exapmle.entity.Investment;
import com.exapmle.repository.InvestmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/investments")
public class InvestmentController {

    @Autowired
    private InvestmentRepository investmentRepository;

    public InvestmentController(InvestmentRepository investmentRepository) {
        this.investmentRepository = investmentRepository;
    }

    @PostMapping("/add")
    public void addInvestment(@RequestBody Investment investment) {
        investmentRepository.save(investment);
    }

    @GetMapping("/all")
    public List<Investment> getInvestment() {
        return investmentRepository.findAll();
    }

    @PutMapping("/update/{id}")
    public void editInvestment(@PathVariable long id, @RequestBody Investment investment) {
        Investment existingInvestment = investmentRepository.findById(id).get();
        Assert.notNull(existingInvestment, "Project not found");
        existingInvestment.setName(investment.getName());
        existingInvestment.setDescription(investment.getDescription());
        existingInvestment.setAmount(investment.getAmount());
        existingInvestment.setDate(investment.getDate());
        investmentRepository.save(existingInvestment);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteInvestment(@PathVariable long id) {
        investmentRepository.deleteById(id);
    }

}
