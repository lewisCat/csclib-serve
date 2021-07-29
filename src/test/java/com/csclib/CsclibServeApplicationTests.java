package com.csclib;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.csclib.entity.Employees;
import com.csclib.entity.Sysuser;
import com.csclib.mapper.EmployeesMapper;
import com.csclib.service.IEmployeesService;
import com.csclib.service.ISysuserService;
import com.csclib.utils.MD5Util;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.nio.file.Path;
import java.sql.SQLException;
import java.util.List;

@SpringBootTest
class CsclibServeApplicationTests {

    @Autowired
    DataSource ds;

    @Test
    void checkMD5Util() {
        System.out.println(MD5Util.getMD5("xylewis"));
    }

    @Test
    void checkDataSource() {
        try {
            System.out.println(ds.getConnection());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Autowired
    EmployeesMapper mapper;
    @Autowired
    IEmployeesService service;

    @Test
    void testPate() {
        QueryWrapper<Employees> wrapper = new QueryWrapper();
        wrapper.eq("sid", "42098419651022033X");
        System.out.println(service.getOne(wrapper));
    }
}
