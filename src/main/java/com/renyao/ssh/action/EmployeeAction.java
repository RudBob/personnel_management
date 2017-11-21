package com.renyao.ssh.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.renyao.ssh.domain.Department;
import com.renyao.ssh.domain.Employee;
import com.renyao.ssh.domain.PageBean;
import com.renyao.ssh.service.DepartmentService;
import com.renyao.ssh.service.EmployeeService;

import java.util.List;

public class EmployeeAction extends ActionSupport implements ModelDriven<Employee> {
    //模型驱动使用的对象
    private Employee employee = new Employee();

    //注入业务层类
    private EmployeeService employeeService;
    private DepartmentService departmentService;

    public void setDepartmentService(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public Employee getModel() {
        return employee;
    }

    public String login() {
        Employee existEmployee = employeeService.login(employee);
        if (existEmployee == null) {
            //登陆失败
            this.addActionError("用户名或密码错误!");
            return INPUT;
        } else {
            //登陆成功
            ActionContext.getContext().getSession().put("existEmployee", existEmployee);
            return SUCCESS;
        }
    }

    private Integer currPage = 1;

    /**
     * 分页查询员工的执行的方法
     */

    public String findAll() {
        PageBean<Employee> pageBean = employeeService.findByPage(currPage);
        ActionContext.getContext().getValueStack().push(pageBean);
        return "findAll";
    }

    /**
     * 跳转到添加员工的界面
     */
    public String saveUI() {
        //查询部门
        List<Department> list = departmentService.findAll();
        //集合用 set 方法， 对象用 push
        ActionContext.getContext().getValueStack().set("list", list);
        return "saveUI";
    }

    /**
     * 保存员工的 save（）
     *
     */
    public String save() {
        employeeService.save(employee);
        return "saveSuccess";
    }

    public String edit(){
        //根据员工ID 查询员工
        employee = employeeService.findById(employee.getEid());
        List<Department> list = departmentService.findAll();
        ActionContext.getContext().getValueStack().set("list",list);
        return "editSuccess";
    }

    /**
     * 修改员工的方法
     */
    public String update(){
        employeeService.update(employee);
        return "updateSuccess";
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public void setCurrPage(Integer currPage) {
        this.currPage = currPage;
    }
}
