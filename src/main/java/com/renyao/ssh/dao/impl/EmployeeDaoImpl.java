package com.renyao.ssh.dao.impl;

import com.renyao.ssh.dao.EmployeeDao;

import com.renyao.ssh.domain.Employee;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import java.util.List;

public class EmployeeDaoImpl extends HibernateDaoSupport implements EmployeeDao {

    @Override
    public Employee findByUsernameAndPassword(Employee employee) {
        String hql = "FROM Employee WHERE username = ? AND password = ?";
        List<Employee> list = this.getHibernateTemplate().find(hql, employee.getUsername(), employee.getPassword());

        if (list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    @Override
    public int findCount() {
        String hql = "select  count(*) from Employee ";
        List<Long> list = this.getHibernateTemplate().find(hql);
        if (list.size() > 0) {
            return list.get(0).intValue();
        }
        return 0;
    }

    @Override
    public List<Employee> findByPage(int begin, int pageSize) {
        DetachedCriteria criteria = DetachedCriteria.forClass(Employee.class);
        List<Employee> list = this.getHibernateTemplate().findByCriteria(criteria, begin, pageSize);
        return list;
    }

    @Override
    public void save(Employee employee) {
        this.getHibernateTemplate().save(employee);
    }



    @Override
    public Employee findById(int eid) {

        return  this.getHibernateTemplate().get(Employee.class,eid);
    }

    @Override
    public void update(Employee employee) {
        this.getHibernateTemplate().update(employee);
    }
}
