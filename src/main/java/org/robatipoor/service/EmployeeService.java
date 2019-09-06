package org.robatipoor.service;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

import org.robatipoor.dao.EmployeeDAOImpl;
import org.robatipoor.dao.InterfaceDAO;
import org.robatipoor.model.Employee;

/**
 * EmployeeService
 */
public class EmployeeService {
    private EmployeeDAOImpl employeeDAO;

    public EmployeeService(InterfaceDAO<Employee, ? extends Serializable> interfaceDAO) {
        this.employeeDAO = (EmployeeDAOImpl)interfaceDAO;
    }

    public void save(Employee entity) {
        employeeDAO.openCurrentSessionwithTransaction();
        employeeDAO.save(entity);
        employeeDAO.closeCurrentSessionwithTransaction();
    }

    public void update(Employee entity) {
        employeeDAO.openCurrentSessionwithTransaction();
        employeeDAO.update(entity);
        employeeDAO.closeCurrentSessionwithTransaction();
    }

    public Employee findById(Long id) {
        employeeDAO.openCurrentSession();
        Employee employee = employeeDAO.findById(id);
        employeeDAO.closeCurrentSession();
        return employee;
    }

    public void delete(Long id) {
        employeeDAO.openCurrentSessionwithTransaction();
        Employee employee = employeeDAO.findById(id);
        employeeDAO.delete(employee);
        employeeDAO.closeCurrentSessionwithTransaction();
    }

    public List<Employee> findAll() {
        employeeDAO.openCurrentSession();
        List<Employee> employees = employeeDAO.findAll();
        employeeDAO.closeCurrentSession();
        return employees;
    }
}