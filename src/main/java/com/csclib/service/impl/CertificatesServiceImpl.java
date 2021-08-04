package com.csclib.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.csclib.entity.Certificates;
import com.csclib.entity.CertificatesView;
import com.csclib.mapper.CertificatesMapper;
import com.csclib.service.ICertificatesService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 服务实现类
 *
 * @author Lewis
 * @since 2021-07-21
 */
@Service
public class CertificatesServiceImpl extends ServiceImpl<CertificatesMapper, Certificates>
    implements ICertificatesService {

  @Override
  public List<CertificatesView> queryByCondition(
      String empname, String company, IPage<CertificatesView> page) {
    List<CertificatesView> list = new ArrayList<>();
    IPage<CertificatesView> certificatesIPage = baseMapper.queryByCondition(empname, company, page);
    list = certificatesIPage.getRecords();
    return list;
  }

  @Override
  public Integer getCountByCondition(String empname, String company) {

    return baseMapper.getCount(empname, company);
  }

  @Override
  public CertificatesView checkCertId(String certid) {
    return baseMapper.checkCertId(certid);
  }
}
