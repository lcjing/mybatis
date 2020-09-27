package com.lcjing.crud.controller;

import com.lcjing.crud.bean.Employee;
import com.lcjing.crud.bean.Msg;
import com.lcjing.crud.service.EmployeeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 员工信息管理
 *
 * @author lcjing
 * @date 2020/09/27
 */
@Controller
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    /**
     * 单个或批量删除
     *
     * @param ids 需要删除的id：1-2-3 以-隔开
     */
    @ResponseBody
    @RequestMapping(value = "/emp/{ids}", method = RequestMethod.DELETE)
    public Msg deleteEmp(@PathVariable("ids") String ids) {
        if (ids.contains("-")) {
            //批量删除
            List<Integer> del_ids = new ArrayList<>();
            String[] str_ids = ids.split("-");
            //组装id的集合
            for (String string : str_ids) {
                del_ids.add(Integer.parseInt(string));
            }
            employeeService.deleteBatch(del_ids);
        } else {
            //单个删除
            Integer id = Integer.parseInt(ids);
            employeeService.deleteEmp(id);
        }
        return Msg.success();
    }

    /**
     * 修改员工信息
     * @param employee 传入的员工信息
     * @return Msg
     */
    @ResponseBody
    @RequestMapping(value = "/emp/{empId}", method = RequestMethod.PUT)
    public Msg saveEmp(Employee employee) {
        employeeService.updateEmp(employee);
        return Msg.success();
    }

    /**
     * 根据id查询员工信息
     * @param id 员工id
     * @return Msg
     */
    @RequestMapping(value = "/emp/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Msg geEmp(@PathVariable("id") Integer id) {
        Employee employee = employeeService.getEmp(id);
        return Msg.success().add("emp", employee);
    }

    /**
     * 查询员工信息--分页返回给前端
     * @param pn 分页信息
     * @return Msg
     */
    @RequestMapping("/emps")
    @ResponseBody
    public Msg getEmpsWithJson(@RequestParam(value = "pn", defaultValue = "1") Integer pn) {
        PageHelper.startPage(pn, 10);
        List<Employee> emps = employeeService.getAll();
        PageInfo page = new PageInfo(emps, 10);
        return Msg.success().add("pageInfo", page);
    }

    /**
     * 查询员工信息--分页
     * @param pn 分页信息
     * @param model 返回实体 model
     * @return Msg
     */
    public String getEmps(@RequestParam(value = "pn", defaultValue = "1") Integer pn, Model model) {
        PageHelper.startPage(pn, 10);
        List<Employee> emps = employeeService.getAll();
        PageInfo page = new PageInfo(emps, 10);
        //连续显示的页数是10页
        //包装查出来的结果，只需要将pageInfo交给页面，封装了详细的分页信息
        //包括查询出来的数据
        model.addAttribute("pageInfo", page);

        return "list";
    }

    /**
     * 新增员工信息
     *
     * @param employee 传入的员工信息
     * @param result   validation
     * @return Msg
     */
    @RequestMapping(value = "/emp", method = RequestMethod.POST)
    @ResponseBody
    public Msg insertEmpsInfo(Employee employee, BindingResult result) {
        employeeService.saveEmpsInfo(employee);
        return Msg.success();
    }

    /**
     * 校验用户名
     *
     * @param empName 员工姓名
     * @return Msg
     */
    @ResponseBody
    @RequestMapping("/checkUser")
    public Msg checkEmp(@RequestParam("empName") String empName) {
        //数据库用户名校验
        boolean b = employeeService.cheUser(empName);
        if (b) {
            return Msg.success();
        } else {
            return Msg.fail();
        }
    }

}
