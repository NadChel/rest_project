package rest_app.controllers;

import org.springframework.web.bind.annotation.*;
import rest_app.exception_handling.InvalidEmployeeIdException;
import rest_app.models.Employee;
import rest_app.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MyController {
    private final EmployeeService employeeService;

    public MyController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> showAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/employees/{id}")
    public Employee showEmployeeById(@PathVariable long id) {
        Employee employee = employeeService.getEmployeeById(id);
        if (employee == null) {
            throw new InvalidEmployeeIdException(id);
        } else return employee;
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee) {
        employeeService.addEmployee(employee);
        return employee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee) {
        employeeService.addEmployee(employee);
        return employee;
    }

    @DeleteMapping("/employees/{id}")
    public String deleteEmployeeById(@PathVariable long id) {
        Employee employee = employeeService.getEmployeeById(id);
        if (employee == null) {
            throw new InvalidEmployeeIdException(id);
        }
        employeeService.deleteEmployeeById(id);
        return String.format("Employee with id %d was removed from the database", id);
    }
}
