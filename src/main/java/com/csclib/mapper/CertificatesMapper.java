package com.csclib.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.csclib.entity.Certificates;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Mapper 接口
 *
 * @author Lewis
 * @since 2021-07-21
 */
@Mapper
public interface CertificatesMapper extends BaseMapper<Certificates> {

    public IPage<Certificates> queryAllCert(IPage<?> page);

    public IPage<Certificates> queryByCondition(@Param("empname") String empname, @Param("company") String company, IPage<?> page);

    public Integer getCount(@Param("empname") String empname, @Param("company") String company);
}
