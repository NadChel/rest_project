package rest_app.dao;

import jakarta.persistence.EntityManagerFactory;
import org.springframework.stereotype.Repository;
import rest_app.models.Employee;

import java.util.List;
@Repository
public class EmployeeDaoImpl implements EmployeeDao {
    private final EntityManagerFactory entityManagerFactory;

    public EmployeeDaoImpl(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return entityManagerFactory.createEntityManager().createQuery("from Employee", Employee.class).getResultList();
    }

    @Override
    public void addEmployee(Employee employee) {
        entityManagerFactory.createEntityManager().merge(employee);
    }

    @Override
    public Employee getEmployeeById(long id) {
        return entityManagerFactory.createEntityManager().getReference(Employee.class, id);
    }

    @Override
    public void deleteEmployeeById(long id) {
        entityManagerFactory.createEntityManager().remove(this.getEmployeeById(id));
    }
}
