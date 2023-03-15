package rest_app.dao;

import rest_app.models.Employee;

import java.util.List;

public interface EmployeeDao {
    List<Employee> getAllEmployees();
    void addEmployee(Employee user);
    Employee getEmployeeById(long id);

    void deleteEmployeeById(long id);
}
