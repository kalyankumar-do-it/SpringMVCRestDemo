package com.techjs.springmvcrestdemo.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.techjs.springmvcrestdemo.dao.EmployeeDAO;
import com.techjs.springmvcrestdemo.entity.Employee;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO
{

	@Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Employee> getAllEmployees() 
    {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Employee", Employee.class)
                .getResultList();
    }

    @Override
    public void saveEmployee(Employee employee) 
    {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(employee);
    }

    @Override
    public Employee getEmployee(int id) 
    {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Employee.class, id);
    }

    @Override
    public void deleteEmployee(int id) 
    {
        Session session = sessionFactory.getCurrentSession();
        Query<Employee> query = session.createQuery("delete from Employee where id = :employeeId");
        query.setParameter("employeeId", id);
        query.executeUpdate();
    }

}
