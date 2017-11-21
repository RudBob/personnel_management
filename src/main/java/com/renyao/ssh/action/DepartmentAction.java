package com.renyao.ssh.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.renyao.ssh.domain.Department;
import com.renyao.ssh.domain.PageBean;
import com.renyao.ssh.service.DepartmentService;
import com.renyao.ssh.service.impl.DepartmentServiceImpl;

public class DepartmentAction extends ActionSupport implements ModelDriven<Department> {

    //模型驱动使用的对象
    private Department department = new Department();

    @Override
    public Department getModel() {
        return department;
    }

    //当前页数
    private Integer currPage = 1;

    public void setCurrPage(Integer currPage) {
        this.currPage = currPage;
    }

    //注入部门管理的Service
    private DepartmentService departmentService;

    //提供一个查询的方法
    public String findAll() {
        PageBean<Department> pageBean = departmentService.findByPage(currPage);
        //将pageBean 存入到值栈中
        ActionContext.getContext().getValueStack().push(pageBean);
        return "findAll";
    }

    //用于跳转
    public String saveUI() {
        return "saveUI";
    }

    //添加部门的执行的方法
    public String save() {
        departmentService.save(department);
        return "saveSuccess";
    }

    //编辑部门的执行的方法
    public String edit() {
        department = departmentService.findById(department.getDid());

        return "editSuccess";
    }

    //修改部门的执行的方法
    public String update(){
        departmentService.update(department);
        return "updateSuccess";
    }

    /**
     * 为了完成级联删除，即删除某一个部门，对应的所有员工都被删除
     * 需要先查询，后删除
     * @return
     */
    public String delete(){
        department = departmentService.findById(department.getDid());
        departmentService.delete(department);
        return "deleteSuccess";
    }


    public void setDepartment(Department department) {
        this.department = department;
    }

    public void setDepartmentService(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

}
