package com.renyao.ssh.service;

import com.renyao.ssh.domain.Department;
import com.renyao.ssh.domain.PageBean;

import java.util.List;

public interface DepartmentService {

    public PageBean<Department> findByPage(Integer currPage);

    //业务层保存部门的方法
    void save(Department department);

    Department findById(int did);

    void update(Department department);

    void delete(Department department);

    List<Department> findAll();
}

