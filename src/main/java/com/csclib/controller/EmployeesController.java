package com.csclib.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.csclib.entity.Employees;
import com.csclib.entity.Sysuser;
import com.csclib.service.IEmployeesService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author Lewis
 * @since 2021-07-21
 */
@Api(tags = "员工信息管理")
@RestController
@RequestMapping("/emp")
public class EmployeesController {
    @Autowired
    IEmployeesService service;

    @CrossOrigin
    @ApiOperation("根据条件获取分页员工信息,条件可选择员工姓名或者所属公司")
    @GetMapping("/list")
    public List<Employees> list(Integer current, Integer size, String company, String empName) {
        if (current == 0 || current == null) {
            current = 1;
        }
        if (size == 0 || size == null) {
            size = 5;
        }
        List<Employees> list = new ArrayList<>();
        QueryWrapper<Employees> wrapper = new QueryWrapper();
        if (!"".equals(company) && company != null) {
            System.out.println("111");
            wrapper.eq("company", company);

        }
        if (!"".equals(empName) && empName != null) {
            System.out.println("2222");
            wrapper.like("empname", empName);
        }
        wrapper.orderByAsc("id");
        Page<Employees> page = new Page<>(current, size);
        page = service.page(page, wrapper);
        list = page.getRecords();
        //list = service.list();
        return list;
    }

    @CrossOrigin
    @ApiOperation("根据公司查询员工信息总数,如果公司为空则返回全部员工总数")
    @GetMapping("/count")
    public Integer getCount(String company, String empName) {
        QueryWrapper<Employees> wrapper = new QueryWrapper<>();
        if (!"".equals(company) && company != null) {
            wrapper.eq("company", company);
        }
        if (!"".equals(empName) && empName != null) {
            wrapper.like("empname", empName);
        }
        return service.count(wrapper);
    }

   /* @CrossOrigin
    @ApiOperation("根据姓名及公司名称模糊查找员工")
    @GetMapping("/ql")
    public List<Employees> queryByName(String empName, String company) {
        List<Employees> list = new ArrayList<Employees>();
        QueryWrapper<Employees> wrapper = new QueryWrapper();
        if (empName != null || empName != null) {
            wrapper.like("name", empName);
        }
        if (company != null || company != "") {
            wrapper.eq("company", company);
        }
        wrapper.like("name", empName);
        list = service.list(wrapper);
        return list;
    }*/

    @CrossOrigin
    @ApiOperation("新增员工")
    @PostMapping("/add")
    public boolean addEmp(@RequestBody Employees newEmp) {
        return service.save(newEmp);
    }

    @CrossOrigin
    @ApiOperation("修改员工信息")
    @PostMapping("/modify")
    public boolean modify(@RequestBody Employees emp) {
        UpdateWrapper<Employees> wrapper = new UpdateWrapper();
        wrapper.eq("id", emp.getId());
        return service.update(emp, wrapper);
    }

    @CrossOrigin
    @ApiOperation("验证员工身份证是否已存在")
    @PostMapping("/cksid")
    public Employees ckSid(String sid) {
        QueryWrapper<Employees> wrapper = new QueryWrapper();
        wrapper.eq("sid", sid);
        return service.getOne(wrapper);
    }

    @CrossOrigin
    @ApiOperation("根据ID删除员工信息")
    @GetMapping("/del")
    public boolean addEmp(String id) {
        UpdateWrapper<Employees> wrapper = new UpdateWrapper<>();
        wrapper.eq("id", id);
        return service.remove(wrapper);
    }

}
