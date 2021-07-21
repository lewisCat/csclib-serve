package com.csclib.handle;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/** 自动注入gtm_create和gtm_modify字段的时间 */
@Component
public class ProMetaObjectHandler implements MetaObjectHandler {
  @Override
  public void insertFill(MetaObject metaObject) {
    this.setFieldValByName("gtmCreate", new Date(), metaObject);
    this.setFieldValByName("gtmModify", new Date(), metaObject);
  }

  @Override
  public void updateFill(MetaObject metaObject) {
    this.setFieldValByName("gtmModify", new Date(), metaObject);
  }
}
