package com.csclib.controller;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.csclib.entity.Certificates;
import com.csclib.entity.CertificatesView;
import com.csclib.service.ICertificatesService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 前端控制器
 *
 * @author Lewis
 * @since 2021-07-21
 */
@RestController
@Api(tags = "证书信息管理")
@RequestMapping("/certificates")
public class CertificatesController {

  @Autowired ICertificatesService certService;

  @CrossOrigin
  @ApiOperation("根据证书ID删除证书")
  @GetMapping("/del")
  public boolean delCertificate(String id) {
    UpdateWrapper<Certificates> wrapper = new UpdateWrapper<>();
    wrapper.eq("id", id);
    return certService.remove(wrapper);
  }

  @CrossOrigin
  @ApiOperation("添加员工证书信息")
  @PostMapping("/add")
  public boolean addCertificato(@RequestBody Certificates certificato) {
    System.out.println(certificato);
    return certService.save(certificato);
  }

  @CrossOrigin
  @ApiOperation("验证证书编号唯一性")
  @GetMapping("/ckcertid")
  public CertificatesView ckByCertid(String certid) {
    return certService.checkCertId(certid);
  }

  @CrossOrigin
  @ApiOperation("根据搜索姓名或者公司获取证书数量")
  @GetMapping("/count")
  public Integer getCount(String seName, String seCompany) {
    if ("".equals(seName)) {
      seName = null;
    }
    if ("".equals(seCompany)) {
      seCompany = null;
    }
    return certService.getCountByCondition(seName, seCompany);
  }

  @CrossOrigin
  @ApiOperation("无条件分页查询全部证书信息")
  @GetMapping("/list")
  public List<CertificatesView> getAllByPage(
      Integer current, Integer size, String empName, String company) {
    IPage<CertificatesView> page = new Page<>(current, size);
    if ("".equals(empName)) {
      empName = null;
    }
    if ("".equals(company)) {
      company = null;
    }
    return certService.queryByCondition(empName, company, page);
  }

  @CrossOrigin
  @ApiOperation("修改证书")
  @PostMapping("/modify")
  public boolean modifyCert(@RequestBody Certificates cert) {
    UpdateWrapper<Certificates> wrapper = new UpdateWrapper<>();
    wrapper.eq("id", cert.getId());
    return certService.update(cert, wrapper);
  }
}
