package com.exapmle.service;

import com.exapmle.entity.Investor;
import com.exapmle.repository.InvestorRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import static java.util.Collections.emptyList;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private InvestorRepository investorRepository;

    public UserDetailsServiceImpl(InvestorRepository investorRepository) {
        this.investorRepository = investorRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Investor investor = investorRepository.findByUsername(username);
        if (investor == null) {
            throw new UsernameNotFoundException(username);
        }
        return new User(investor.getUsername(), investor.getPassword(), emptyList());
    }
}
