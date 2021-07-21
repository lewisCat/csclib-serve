package com.csclib.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableField;
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
@ApiModel(value="Certificates对象", description="")
public class Certificates implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

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
    private Long empid;

    @Version
    private Integer version;

    private Date gmtCreate;

    private Date gmtModify;

    @TableLogic
    private Integer deleted;


}
