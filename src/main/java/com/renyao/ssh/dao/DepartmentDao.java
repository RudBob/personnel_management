package com.renyao.ssh.dao;

import com.renyao.ssh.domain.Department;

import java.util.List;

public interface DepartmentDao {
    int findCount();

    List<Department> findByPage(int begin, int pageSize);

    void save(Department department);

    Department findById(int did);

    void update(Department department);

    void delete(Department department);

    List findAll();

}
