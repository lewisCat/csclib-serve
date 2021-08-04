package com.csclib.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.csclib.entity.Certificates;
import com.csclib.entity.CertificatesView;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * Mapper 接口
 *
 * @author Lewis
 * @since 2021-07-21
 */
@Mapper
public interface CertificatesMapper extends BaseMapper<Certificates> {

  public IPage<CertificatesView> queryAllCert(IPage<?> page);

  public IPage<CertificatesView> queryByCondition(
      @Param("empname") String empname, @Param("company") String company, IPage<?> page);

  public Integer getCount(@Param("empname") String empname, @Param("company") String company);

  public CertificatesView checkCertId(@Param("certid") String certid);
}
