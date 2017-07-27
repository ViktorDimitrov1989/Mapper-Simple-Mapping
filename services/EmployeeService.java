package app.services;

import app.model.Employee;

import java.util.Date;
import java.util.List;

public interface EmployeeService {

    void registerEmployee(Employee employee);

    List<Employee> findOlderEmployees(Date date);

}
