package app;

import app.dto.DtoMappingUtil;
import app.dto.EmployeeDto;
import app.dto.ManagerDto;
import app.model.Address;
import app.model.Employee;
import app.model.Street;
import app.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class TerminalController implements CommandLineRunner{
    private EmployeeService employeeService;

    @Autowired
    public TerminalController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public void run(String... strings) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");


        Street street = new Street();
        street.setName("Okolovrustna");
        Address address = new Address();
        address.setStreet(street);

        Employee employee =
                new Employee("Pesho", "Ivanov", BigDecimal.valueOf(10L), sdf.parse("19700105"),
                        address);

        Employee manager =
                new Employee("Manager", "Stamatov", BigDecimal.valueOf(345043L), sdf.parse("19830105"),
                        address);

        //convert from base to DTO
        EmployeeDto employeeDto = DtoMappingUtil.convert(employee, EmployeeDto.class);
        //System.out.println("----------------------------------To-DTO---------------------------------");
        //System.out.println(employeeDto);
        //System.out.println("----------------------------------To-DTO-manager---------------------------------");
        manager.addManagedEmployee(employee);
        employee.setManager(manager);
        this.employeeService.registerEmployee(manager);
        ManagerDto managerDto =  DtoMappingUtil.convert(manager, ManagerDto.class);
        //System.out.println(managerDto);
        //convert from DTO to base
        Employee convertedEmployee = DtoMappingUtil.convert(employeeDto, Employee.class);
        //System.out.println("----------------------------------From-DTO---------------------------------");
        //System.out.println(convertedEmployee);

        //task 3//



        List<Employee> employees = this.employeeService.findOlderEmployees(sdf.parse("19900101"));
        List<EmployeeDto> olderEmployeeDtos = DtoMappingUtil.convertToEmployeesDto(employees);

        System.out.println(olderEmployeeDtos);

    }
}
