package com.embarkX.firstjobapp.company.impl;

import com.embarkX.firstjobapp.company.Company;
import com.embarkX.firstjobapp.company.CompanyRepository;
import com.embarkX.firstjobapp.company.CompanyService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {

    private CompanyRepository companyRepository;

    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }
}
