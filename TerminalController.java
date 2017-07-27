package app;

import app.dto.DtoMappingUtil;
import app.dto.EmployeeDto;
import app.model.Address;
import app.model.Employee;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

import java.math.BigDecimal;
import java.util.Date;

@Controller
public class TerminalController implements CommandLineRunner{
    @Override
    public void run(String... strings) throws Exception {
        Address address = new Address("Okolovrustna");
        Employee e1 =
                new Employee("Pesho", "Ivanov", BigDecimal.valueOf(10L), new Date(),
                        address);

        //convert from base to DTO
        EmployeeDto dtoObject = DtoMappingUtil.convertEmployee(e1);
        System.out.println(dtoObject);
        //convert from DTO to base
        Employee convertedEmployee = DtoMappingUtil.convertEmployeeDto(dtoObject);
        System.out.println(convertedEmployee);

    }
}
