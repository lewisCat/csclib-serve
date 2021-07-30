package com.csclib.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.csclib.entity.Certificates;
import com.csclib.service.ICertificatesService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

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
@Api(tags = "证书信息管理")
@RequestMapping("/certificates")
public class CertificatesController {

    @Autowired
    ICertificatesService service;

    @CrossOrigin
    @ApiOperation("根据员工ID删除证书")
    @GetMapping("/del")
    public boolean delCertificate(String empid) {
        UpdateWrapper<Certificates> wrapper = new UpdateWrapper<>();
        wrapper.eq("empid", empid);
        return service.remove(wrapper);
    }

    @CrossOrigin
    @ApiOperation("根据员工ID查找证书信息")
    @GetMapping("/qbempid")
    public List<Certificates> queryByEmpid(String empid) {
        QueryWrapper<Certificates> wrapper = new QueryWrapper<>();
        wrapper.eq("empid", empid);
        return service.list(wrapper);
    }

}
