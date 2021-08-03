package com.csclib.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.csclib.entity.Certificates;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author Lewis
 * @since 2021-07-21
 */
public interface ICertificatesService extends IService<Certificates> {

    public List<Certificates> queryByCondition(@Param("empname") String empname, @Param("company") String company, IPage<Certificates> page);

    public Integer getCountByCondition(@Param("empname") String empname, @Param("company") String company);
}
