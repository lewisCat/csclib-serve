package com.csclib.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.csclib.entity.Certificates;
import com.csclib.mapper.CertificatesMapper;
import com.csclib.service.ICertificatesService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
public class CertificatesServiceImpl extends ServiceImpl<CertificatesMapper, Certificates> implements ICertificatesService {

    @Override
    public List<Certificates> queryByCondition(String empname, String company, IPage<Certificates> page) {
        List<Certificates> list = new ArrayList<>();
        IPage<Certificates> certificatesIPage = baseMapper.queryByCondition(empname, company, page);
        list = certificatesIPage.getRecords();
        return list;
    }

    @Override
    public Integer getCountByCondition(String empname, String company) {
        System.out.println(empname + "============" + company);
        return baseMapper.getCount(empname, company);
    }

}
