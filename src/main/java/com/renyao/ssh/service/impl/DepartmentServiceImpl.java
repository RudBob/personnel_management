package com.renyao.ssh.service.impl;

import com.renyao.ssh.dao.impl.DepartmentDaoImpl;
import com.renyao.ssh.domain.Department;
import com.renyao.ssh.domain.PageBean;
import com.renyao.ssh.service.DepartmentService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public class DepartmentServiceImpl implements DepartmentService {
    //注入部门管理的 DAO
    private DepartmentDaoImpl departmentDao;

    public void setDepartmentDao(DepartmentDaoImpl departmentDao) {
        this.departmentDao = departmentDao;
    }

    @Override
    // 分页查询部门的方法
    public PageBean<Department> findByPage(Integer currPage) {
        PageBean<Department> pageBean = new PageBean<Department>();
        // 封装当前的页数
        pageBean.setCurrPage(currPage);
        //封装每页所显示的记录数
        int pageSize = 3;
        pageBean.setPageSize(pageSize);
        //封装总记录数
        int totalCount = departmentDao.findCount();
        pageBean.setTotalCount(totalCount);
        //封装总页数
        double tc = totalCount;
        Double num = Math.ceil(tc / pageSize);       //对double 向上取整
        pageBean.setTotalPage(num.intValue());
        //封装每页显示的数据
        int begin = (currPage - 1) * pageSize;
        List<Department> list = departmentDao.findByPage(begin, pageSize);

        pageBean.setList(list);
        return pageBean;
    }

    @Override
    //业务层保存部门的方法
    public void save(Department department) {
        departmentDao.save(department);
    }

    @Override
    public Department findById(int did) {

        return departmentDao.findById(did);
    }

    @Override
    public void update(Department department) {
        departmentDao.update(department);
    }

    @Override
    public void delete(Department department) {
        departmentDao.delete(department);
    }

    @Override
    //查询所有部门的方法
    public List<Department> findAll() {

        return departmentDao.findAll();
    }
}
