package rest_app.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import rest_app.dao.EmployeeDao;
import rest_app.models.Employee;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeDao employeeDao;

    public EmployeeServiceImpl(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeDao.getAllEmployees();
    }
    @Override
    public Employee getEmployeeById(long id) {
        return employeeDao.getEmployeeById(id);
    }

    @Override
    public Model setAddEmployeeModel(Model model) {
        return model.addAttribute("employee", new Employee());
    }

    @Override
    @Transactional
    public void addEmployee(Employee employee) {
        employeeDao.addEmployee(employee);
    }

    @Override
    public Model setUpdateEmployeeModel(Model model, long id) {
        return model.addAttribute("user", employeeDao.getEmployeeById(id));
    }

    @Override
    @Transactional
    public void deleteEmployeeById(long id) {
        employeeDao.deleteEmployeeById(id);
    }
}
