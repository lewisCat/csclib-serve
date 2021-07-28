package com.csclib.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.csclib.entity.Sysuser;
import com.csclib.mapper.SysuserMapper;
import com.csclib.service.ISysuserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Wrapper;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author Lewis
 * @since 2021-07-21
 */
@Service
public class SysuserServiceImpl extends ServiceImpl<SysuserMapper, Sysuser> implements ISysuserService {
}