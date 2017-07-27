package app.dto;

import app.model.Employee;
import org.modelmapper.ModelMapper;

public final class DtoMappingUtil {
    private static ModelMapper mapper = new ModelMapper();

    private DtoMappingUtil() {
    }

    public static EmployeeDto convertEmployee(Employee employee){
        return mapper.map(employee, EmployeeDto.class);
    }

    public static Employee convertEmployeeDto(EmployeeDto employeeDto){
        return mapper.map(employeeDto, Employee.class);
    }



}
