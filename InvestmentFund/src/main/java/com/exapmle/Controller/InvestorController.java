package com.exapmle.Controller;

import com.exapmle.entity.Investor;
import com.exapmle.repository.InvestorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/investors")
public class InvestorController {

    @Autowired
    private InvestorRepository investorRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public InvestorController(InvestorRepository investorRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.investorRepository = investorRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @RequestMapping(value = "/sign-up", method = RequestMethod.POST)
    public void signUp(@RequestBody Investor investor) {
        investor.setPassword(bCryptPasswordEncoder.encode(investor.getPassword()));
        investorRepository.save(investor);
    }
}
