package org.robatipoor.dao;

import java.util.List;

import org.robatipoor.model.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * CompanyDaoImpl
 */
public class EmployeeDAOImpl extends SessionManager implements InterfaceDAO<Employee, Long> {

    private static final Logger LOG = LoggerFactory.getLogger(EmployeeDAOImpl.class);

    public EmployeeDAOImpl() {
    }

    @Override
    public Employee findById(Long id) {
        Employee employee = (Employee) getCurrentSession().get(Employee.class, id);
        return employee;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Employee> findAll() {
        var employees = (List<Employee>) getCurrentSession().createQuery("from Employee").list();
        return employees;
    }

    @Override
    public boolean save(Employee entity) {
        try {
            getCurrentSession().save(entity);
        } catch (Exception e) {
            LOG.error("Save Employee Faild {}", e.toString());
            return false;
        }
        return true;
    }

    @Override
    public boolean delete(Employee entity) {
        try {
            getCurrentSession().delete(entity);
        } catch (Exception e) {
            LOG.error("Delete Employee Faild {}", e.toString());
            return false;
        }
        return true;
    }

    @Override
    public boolean update(Employee entity) {
        try {
            getCurrentSession().update(entity);
        } catch (Exception e) {
            LOG.error("Update Employee Faild {}", e.toString());
            return false;
        }
        return true;
    }

}