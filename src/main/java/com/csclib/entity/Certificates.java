package com.csclib.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.util.Date;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 *
 * </p>
 *
 * @author Lewis
 * @since 2021-07-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "Certificates对象", description = "")
public class Certificates implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private String id;

    @ApiModelProperty(value = "证书编号")
    private String certid;

    @TableField("certName")
    private String certname;

    @ApiModelProperty(value = "注册日期")
    @TableField("registryDate")
    private Date registrydate;

    @ApiModelProperty(value = "启用日期")
    @TableField("applyDate")
    private Date applydate;

    @ApiModelProperty(value = "失效日期")
    @TableField("loseEfficacyDate")
    private Date loseefficacydate;

    @ApiModelProperty(value = "在职状态")
    private Integer status;

    @ApiModelProperty(value = "关联员工ID")
    private String empid;

    @Version
    private Integer version;

    @TableField(fill = FieldFill.INSERT)
    private Date gtmCreate;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date gtmModify;

    @TableLogic
    private Integer deleted;

    private String empname;

    private String company;
}
