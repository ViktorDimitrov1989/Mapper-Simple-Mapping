package app.services;

import app.model.Employee;
import app.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public void registerEmployee(Employee employee) {
        this.employeeRepository.save(employee);
    }

    @Override
    public List<Employee> findOlderEmployees(Date date) {
        return this.employeeRepository.findAllByBirthDateBeforeOrderBySalaryDesc(date);
    }
}
