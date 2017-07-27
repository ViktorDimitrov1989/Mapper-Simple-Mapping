package app.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class EmployeeDto implements Serializable {

    private String firstName;
    private String lastName;
    private BigDecimal salary;
    private String addressStreet;

    public EmployeeDto() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public String getAddressStreet() {
        return addressStreet;
    }

    public void setAddressStreet(String addressStreet) {
        this.addressStreet = addressStreet;
    }

    @Override
    public String toString() {
        return String.format("First name: %s\n" +
                "Last name: %s\n" +
                "Salary: %.2f\n" +
                "Address: %s", this.firstName, this.lastName, this.salary, this.addressStreet);
    }
}
