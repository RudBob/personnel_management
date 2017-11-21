package com.renyao.ssh.service.impl;

import com.renyao.ssh.dao.EmployeeDao;
import com.renyao.ssh.dao.impl.EmployeeDaoImpl;
import com.renyao.ssh.domain.Employee;
import com.renyao.ssh.domain.PageBean;
import com.renyao.ssh.service.EmployeeService;

import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeDaoImpl employeeDao;

    public void setEmployeeDao(EmployeeDaoImpl employeeDao) {
        this.employeeDao = employeeDao;
    }

    public EmployeeDaoImpl getEmployeeDao() {
        return employeeDao;
    }

    @Override
    public Employee login(Employee employee) {
        Employee existEmployee = employeeDao.findByUsernameAndPassword(employee);

        return existEmployee;
    }

    @Override
    /**
     *  业务层的分层查询员工的方法
     */
    public PageBean<Employee> findByPage(Integer currPage) {
        PageBean<Employee> pageBean = new PageBean<Employee>();
        // 封装当前的页数
        pageBean.setCurrPage(currPage);
        //分装煤业显示的记录数
        int pageSize = 3;
        pageBean.setPageSize(pageSize);
        //封装总记录数
        int totalCount = employeeDao.findCount();
        pageBean.setTotalPage(totalCount);
        //封装总页数
        double tc = totalCount;
        Double num = Math.ceil(tc / pageSize);
        pageBean.setTotalPage(num.intValue());
        //封装每页显示的数据
        int begin = (currPage - 1) * pageSize;
        List<Employee> list = employeeDao.findByPage(begin, pageSize);
        pageBean.setList(list);
        return pageBean;
    }

    @Override
    public void save(Employee employee) {
        employeeDao.save(employee);
    }

    @Override
    //根据员工ID查询员工的方法
    public Employee findById(int eid) {
        Employee employee = employeeDao.findById(eid);
        return employee;
    }

    @Override
    public void update(Employee employee) {
        employeeDao.update(employee);
    }
}
