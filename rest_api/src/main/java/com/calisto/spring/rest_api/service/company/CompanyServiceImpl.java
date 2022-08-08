package com.calisto.spring.rest_api.service.company;

import com.calisto.spring.rest_api.DaO.company.CompanyDaO;
import com.calisto.spring.rest_api.entity.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService{

    @Autowired
    CompanyDaO companyDaO;
    @Override
    @Transactional
    public List<Company> getAll() {
        return companyDaO.getAll();
    }

    @Override
    @Transactional
    public Company add(Company company) {
    companyDaO.add(company);
    return company;
    }
}
