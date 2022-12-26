package com.calisto.spring.rest_api.service.employee;

import com.calisto.spring.rest_api.DaO.company.CompanyDaO;
import com.calisto.spring.rest_api.DaO.employee.EmployeeDaO;
import com.calisto.spring.rest_api.entity.Company;
import com.calisto.spring.rest_api.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    CompanyDaO companyDaO;
    @Autowired
    EmployeeDaO employeeDaO;

    @Override
    @Transactional
    public List<Employee> getAll() {
        return employeeDaO.getAll();
    }

    @Override
    @Transactional
    public Employee addEmployee(Employee employee) {
        Employee empl = employeeDaO.addEmployee(employee);
        if (empl.getVid_position()==1){
            Company company = companyDaO.getCompany(employee.getCompany_id());
            company.setSupervisor(employee.getId());
            companyDaO.add(company);
        }
        if (empl.getVid_position()==2){
            Company company = companyDaO.getCompany(employee.getCompany_id());
            company.setChiefAccountant(employee.getId());
            companyDaO.add(company);
        }
        return empl;
    }

    @Override
    @Transactional
    public Employee getEmployee(int id) {
        return employeeDaO.getEmployee(id);
    }

    @Override
    @Transactional
    public void delete(int id) {
        employeeDaO.delete(id);
    }

    @Override
    @Transactional
    public Employee editEmployee(Employee employee) {
        return employeeDaO.addEmployee(employee);
    }
}
