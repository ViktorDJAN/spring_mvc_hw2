package ru.kashtanov.spring_mvc_hw2.dao;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import ru.kashtanov.spring_mvc_hw2.models.Employee;

import java.util.ArrayList;
import java.util.List;

@Component
public class EmployeeDAO {
    private static int EMPLOYEE_COUNT;
    private List<Employee> employeeList;
 /** It is an initialization block of employees*/
    {
        employeeList = new ArrayList<Employee>();
        employeeList.add(new Employee(++EMPLOYEE_COUNT,"John","Rambo","soldier"));
        employeeList.add(new Employee(++EMPLOYEE_COUNT,"Peter","Parker","superhero"));
        employeeList.add(new Employee(++EMPLOYEE_COUNT,"Anakin","Skywalker","young padawan"));
    }

    public List<Employee>getAllEmployees(){
        return employeeList;
    }

    public void saveEmployee(Employee employee){
        employee.setId(++EMPLOYEE_COUNT);
        employeeList.add(employee);
    }

    public Employee showEmployeeWithId(int id){
        return employeeList.stream().filter(employee -> employee.getId()==id).findAny().orElse(null);
    }

    public void update(int id , Employee employeeForUpdating){
        Employee updatedEmployee = showEmployeeWithId(id);
        updatedEmployee.setFirstName(employeeForUpdating.getFirstName());
        updatedEmployee.setSecondName(employeeForUpdating.getSecondName());
        updatedEmployee.setPosition(employeeForUpdating.getPosition());

    }

    public void  delete(int id){
        Employee employee = showEmployeeWithId(id);
        if(employeeList.contains(employee)){
            employeeList.remove(employee);
        }
    }

}
