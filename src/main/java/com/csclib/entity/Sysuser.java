package com.csclib.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Lewis
 * @since 2021-07-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "Sysuser对象", description = "")
public class Sysuser implements Serializable {

  private static final long serialVersionUID = 1L;

  @TableId(value = "id", type = IdType.ASSIGN_ID)
  private Long id;

  private String sysname;

  private String syspwd;

  private Integer roleid;

  @TableField(fill = FieldFill.INSERT)
  private Date gtmCreate;

  @TableField(fill = FieldFill.INSERT_UPDATE)
  private Date gtmModify;

  @Version private Integer version;

  @TableLogic private Integer deleted;
}
