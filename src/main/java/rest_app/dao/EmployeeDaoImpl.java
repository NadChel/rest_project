package rest_app.dao;

import jakarta.persistence.PersistenceContext;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import rest_app.models.Employee;

import java.util.List;
@Repository
public class EmployeeDaoImpl implements EmployeeDao {
    @PersistenceContext
    private Session session;

    @Override
    public List<Employee> getAllEmployees() {
        return session.createQuery("from Employee", Employee.class).getResultList();
    }

    @Override
    public void addEmployee(Employee employee) {
        System.out.println("employee: " + employee);
        Employee returnedEmployee = session.merge(employee);
        System.out.println("returnedEmployee: " + returnedEmployee);
    }

    @Override
    public Employee getEmployeeById(long id) {
        return session.get(Employee.class, id);
    }

    @Override
    public void deleteEmployeeById(long id) {
        session.remove(this.getEmployeeById(id));
    }
}
