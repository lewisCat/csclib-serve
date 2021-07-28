package com.csclib.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.FieldFill;
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
@ApiModel(value="Projects对象", description="")
public class Projects implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private String id;

    @ApiModelProperty(value = "项目名称")
    private String proname;

    @ApiModelProperty(value = "项目所在省市")
    private String area;

    @ApiModelProperty(value = "合同金额")
    private BigDecimal price;

    @ApiModelProperty(value = "签订日期")
    @TableField("contractDate")
    private Date contractdate;

    @ApiModelProperty(value = "完工日期")
    @TableField("completionDate")
    private Date completiondate;

    @ApiModelProperty(value = "负责人名称")
    private String director;

    @Version
    private Integer version;

    @TableField(fill = FieldFill.INSERT)
    private Date gtmCreate;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date gtmModify;

    @TableLogic
    private Integer deleted;


}
