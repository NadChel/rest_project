package rest_app.service;

import org.springframework.ui.Model;
import rest_app.models.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees();
    Model setAddEmployeeModel(Model model);
    void addEmployee(Employee user);
    Model setUpdateEmployeeModel(Model mode, long id);

    void deleteEmployeeById(long id);
}
