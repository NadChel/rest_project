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
        session.merge(employee);
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
