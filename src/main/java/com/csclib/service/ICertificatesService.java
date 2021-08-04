package com.csclib.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.csclib.entity.Certificates;
import com.csclib.entity.CertificatesView;

import java.util.List;

/**
 * 服务类
 *
 * @author Lewis
 * @since 2021-07-21
 */
public interface ICertificatesService extends IService<Certificates> {

  public List<CertificatesView> queryByCondition(
      String empname, String company, IPage<CertificatesView> page);

  public Integer getCountByCondition(String empname, String company);

  public CertificatesView checkCertId(String certid);
}
