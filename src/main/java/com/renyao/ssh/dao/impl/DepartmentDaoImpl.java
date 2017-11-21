package com.renyao.ssh.dao.impl;

import com.renyao.ssh.dao.DepartmentDao;
import com.renyao.ssh.domain.Department;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import java.util.List;

public class DepartmentDaoImpl extends HibernateDaoSupport implements DepartmentDao {
    private SessionFactory sessionFactory;


    @Override
    //统计部门个数
    public int findCount() {
        String hql = "select  count(*) from Department ";
        List<Long> list = this.getHibernateTemplate().find(hql);
        if (list.size() > 0) {
            return list.get(0).intValue();
        }
        return 0;
    }

    @Override
    //分页查询的
    public List<Department> findByPage(int begin, int pageSize) {
        DetachedCriteria criteria = DetachedCriteria.forClass(Department.class);
        List<Department> list = this.getHibernateTemplate().findByCriteria(criteria, begin, pageSize);
        return list;
    }

    @Override
    public void save(Department department) {
        this.getHibernateTemplate().save(department);
    }

    @Override
    public Department findById(int did) {
        return this.getHibernateTemplate().get(Department.class, did);
    }

    @Override
    public void update(Department department) {
        this.getHibernateTemplate().update(department);
    }

    @Override
    public void delete(Department department) {
        this.getHibernateTemplate().delete(department);
    }

    @Override
    public List<Department> findAll() {
        return this.getHibernateTemplate().find("from Department ");

    }
}
