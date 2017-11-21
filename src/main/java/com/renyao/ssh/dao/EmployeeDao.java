package com.renyao.ssh.dao;

import com.renyao.ssh.domain.Employee;

import java.util.List;

public interface EmployeeDao {
    Employee findByUsernameAndPassword(Employee employee);

    int findCount();

    List<Employee> findByPage(int begin, int pageSize);

    void save(Employee employee);

    Employee findById(int eid);

    void update(Employee employee);
}
