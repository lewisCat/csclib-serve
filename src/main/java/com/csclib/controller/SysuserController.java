package com.csclib.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.csclib.entity.Sysuser;
import com.csclib.service.ISysuserService;
import com.csclib.utils.MD5Util;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Sysuser前端控制器
 *
 * @author Lewis
 * @since 2021-07-21
 */
@Api(tags = "系统用户管理")
@RestController
@RequestMapping("/sysuser")
public class SysuserController {

    @Autowired
    ISysuserService service;

    @CrossOrigin
    @ApiOperation("新增系统用户")
    @PostMapping("/add")
    public boolean add(@RequestBody Sysuser newSysuser) {
        newSysuser.setSyspwd(MD5Util.getMD5(newSysuser.getSyspwd()));
        boolean save = service.save(newSysuser);
        return save;
    }

    @CrossOrigin
    @ApiOperation("系统用户登录验证")
    @PostMapping("/login")
    public Sysuser login(@RequestBody Sysuser logSysuser) {
        System.out.println(logSysuser);
        QueryWrapper<Sysuser> wp = new QueryWrapper<Sysuser>();
        Map<String, Object> map = new HashMap<>();
        map.put("sysname", logSysuser.getSysname());
        map.put("syspwd", MD5Util.getMD5(logSysuser.getSyspwd()));
        wp.allEq(map);
        Sysuser one = service.getOne(wp);
        return one;
    }

    @CrossOrigin
    @ApiOperation("系统用户修改")
    @PostMapping("/modify")
    public boolean modify(@RequestBody Sysuser user) {
        user.setSyspwd(MD5Util.getMD5(user.getSyspwd()));
        UpdateWrapper<Sysuser> wp = new UpdateWrapper<Sysuser>();
        wp.eq("id", user.getId());
        return service.update(user, wp);
    }

    @CrossOrigin
    @ApiOperation("删除系统用户")
    @GetMapping("/del")
    public boolean delete(String userid) {
        UpdateWrapper<Sysuser> wp = new UpdateWrapper<>();
        wp.eq("id", userid);
        return service.remove(wp);
    }

    @CrossOrigin
    @ApiOperation("获取全部系统用户")
    @GetMapping("/list")
    public List<Sysuser> list() {
        List<Sysuser> list = service.list();
        return list;
    }

    @CrossOrigin
    @ApiOperation("根据用户名获取用户")
    @GetMapping("/query")
    public Sysuser queryBySysname(String userName) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("sysName", userName);
        Sysuser one = service.getOne(wrapper);
        return one;
    }
}
