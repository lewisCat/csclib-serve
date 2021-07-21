package com.csclib.service.impl;

import com.csclib.entity.Employees;
import com.csclib.mapper.EmployeesMapper;
import com.csclib.service.IEmployeesService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Lewis
 * @since 2021-07-21
 */
@Service
public class EmployeesServiceImpl extends ServiceImpl<EmployeesMapper, Employees> implements IEmployeesService {

}
