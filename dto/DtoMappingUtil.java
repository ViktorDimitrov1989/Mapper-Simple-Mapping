package app.dto;

import app.model.Employee;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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

    //generic convert
    public static <S,D> D convert(S source, Class<D> destinationClass){
        return mapper.map(source, destinationClass);
    }

    //custom set the properties
    /*public static EmployeeDto customConvert(Employee source, Class<EmployeeDto> destinationClass){
        return mapper.map(source, destinationClass);
    }*/

    //custom convert to collection
    public static List<EmployeeDto> convertToEmployeesDto(Iterable<Employee> sources){
        //add the mapping and then convert all the objects
        PropertyMap<Employee, EmployeeDto> propertyMap = new PropertyMap<Employee, EmployeeDto>() {
            @Override
            protected void configure() {
                map().setManagerLastName(source.getManager().getLastName());
            }
        };
        mapper.addMappings(propertyMap);

        List<EmployeeDto> resultList = new ArrayList();

        for (Employee employee : sources) {
            resultList.add(convert(employee, EmployeeDto.class));
        }

        return resultList;
    }

    //generic convert for collections
    public static <S,D> List<D> convert(Iterable<S> sources, Class<D> destClass){
        List<D> resultList = new ArrayList<D>();

        for (S s : sources) {
            resultList.add(convert(s, destClass));
        }

        return resultList;
    }




}
