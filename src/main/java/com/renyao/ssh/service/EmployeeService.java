package com.renyao.ssh.service;

import com.renyao.ssh.domain.Employee;
import com.renyao.ssh.domain.PageBean;

public interface EmployeeService {
    public Employee login(Employee employee);

    PageBean<Employee> findByPage(Integer currPage);

    void save(Employee employee);

    Employee findById(int eid);

    void update(Employee employee);
}
