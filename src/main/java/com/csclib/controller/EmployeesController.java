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
@RestController
@RequestMapping("/emp")
public class EmployeesController {
    @Autowired
    IEmployeesService service;

    @CrossOrigin
    @ApiOperation("分页获取全部员工信息")
    @GetMapping("/list")
    public List<Employees> list(Integer current, Integer size) {
        List<Employees> list = new ArrayList<>();
        QueryWrapper<Employees> wrapper = new QueryWrapper();
        Page<Sysuser> page = new Page<>(current, size);
        page.setCurrent(current);
        //service.page(page, wrapper);
        return list;
    }

    @CrossOrigin
    @ApiOperation("根据姓名模糊查找员工")
    @GetMapping("/qlname")
    public List<Employees> queryByName(String empName) {
        List<Employees> list = new ArrayList<Employees>();
        QueryWrapper<Employees> wrapper = new QueryWrapper();
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


}
