package com.csclib.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.plugins.pagination.PageDto;
import com.csclib.entity.Employees;
import com.csclib.entity.Sysuser;
import com.csclib.service.IEmployeesService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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
    @ApiOperation("分页获取全部员工信息")
    @GetMapping("/list")
    public List<Employees> list(Integer current, Integer size) {
        if (current == 0 || current == null) {
            current = 1;
        }
        if (size == 0 || size == null) {
            size = 20;
        }
        List<Employees> list = new ArrayList<>();
        QueryWrapper<Employees> wrapper = new QueryWrapper();
        wrapper.orderByAsc("id");
        Page<Employees> page = new Page<>(current, size);
        page = service.page(page, wrapper);
        list = page.getRecords();
        return list;
    }

    @CrossOrigin
    @ApiOperation("根据公司查询员工信息总数,如果公司为空则返回全部员工总数")
    @GetMapping("/count")
    public Integer getCount(String company) {
        if (company == "" || company == null) {
            return service.count();
        }
        QueryWrapper<Employees> wrapper = new QueryWrapper<>();
        wrapper.eq("company", company);
        return service.count(wrapper);
    }

    @CrossOrigin
    @ApiOperation("根据姓名模糊查找员工")
    @GetMapping("/qlname")
    public List<Employees> queryByName(String empName) {
        List<Employees> list = new ArrayList<Employees>();
        QueryWrapper<Employees> wrapper = new QueryWrapper();
        wrapper.eq("status", 0);
        wrapper.like("name", empName);
        list = service.list(wrapper);
        return list;
    }

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
    @ApiOperation("根据身份证号查询员工")
    @PostMapping("/qbsid")
    public Employees queryBySid(@RequestBody String sid) {
        QueryWrapper<Employees> wrapper = new QueryWrapper();
        wrapper.eq("sid", sid);
        return service.getOne(wrapper);
    }
}
