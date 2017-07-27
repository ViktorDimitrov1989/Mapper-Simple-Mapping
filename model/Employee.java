package app.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "employees")
public class Employee {
    private Long id;
    private String firstName;
    private String lastName;
    private BigDecimal salary;
    private Date birthDate;
    private Address address;
    private Employee manager;
    private Set<Employee> managedEmployees;

    public Employee() {
        this.managedEmployees = new HashSet<>();
    }

    public Employee(String firstName, String lastName, BigDecimal salary, Date birthDate, Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.birthDate = birthDate;
        this.address = address;
        this.managedEmployees = new HashSet<>();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "first_name")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "last_name")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name = "salary")
    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    @Column(name = "birth_date")
    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "manager_id")
    public Employee getManager() {
        return manager;
    }

    @OneToMany(mappedBy = "manager", cascade = CascadeType.ALL)
    public Set<Employee> getManagedEmployees() {
        return managedEmployees;
    }

    public void setManagedEmployees(Set<Employee> managedEmployees) {
        this.managedEmployees = managedEmployees;
    }

    public void setManager(Employee manager) {
        this.manager = manager;
    }

    public void addManagedEmployee(Employee employee) {
        this.managedEmployees.add(employee);
    }

    @Override
    public String toString() {
        return String.format("Id: %d\n" +
                "First name: %s\n" +
                "Last name: %s\n" +
                "Salary: %.2f\n" +
                "Birth date: %s\n" +
                "Address: %s",
                this.id, this.firstName, this.lastName, this.salary, this.birthDate, this.address);
    }
}
