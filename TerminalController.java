package app;

import app.dto.DtoMappingUtil;
import app.dto.EmployeeDto;
import app.dto.ManagerDto;
import app.model.Address;
import app.model.Employee;
import app.model.Street;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

import java.math.BigDecimal;
import java.util.Date;

@Controller
public class TerminalController implements CommandLineRunner{
    @Override
    public void run(String... strings) throws Exception {
        Street street = new Street();
        street.setName("Okolovrustna");
        Address address = new Address();
        address.setStreet(street);

        Employee employee =
                new Employee("Pesho", "Ivanov", BigDecimal.valueOf(10L), new Date(),
                        address);

        Employee manager =
                new Employee("Manager", "Stamatov", BigDecimal.valueOf(345043L), new Date(),
                        address);

        //convert from base to DTO
        EmployeeDto employeeDto = DtoMappingUtil.convert(employee, EmployeeDto.class);
        System.out.println("----------------------------------To-DTO---------------------------------");
        System.out.println(employeeDto);
        System.out.println("----------------------------------To-DTO-manager---------------------------------");
        manager.addManagedEmployee(employee);
        ManagerDto managerDto =  DtoMappingUtil.convert(manager, ManagerDto.class);
        System.out.println(managerDto);
        //convert from DTO to base
        Employee convertedEmployee = DtoMappingUtil.convert(employeeDto, Employee.class);
        System.out.println("----------------------------------From-DTO---------------------------------");
        System.out.println(convertedEmployee);

    }
}
