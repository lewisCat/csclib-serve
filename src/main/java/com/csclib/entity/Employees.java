package com.csclib.entity;

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
@ApiModel(value="Employees对象", description="")
public class Employees implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    @ApiModelProperty(value = "姓名")
    private String name;

    @ApiModelProperty(value = "身份证")
    private String sid;

    @ApiModelProperty(value = "入职日期")
    @TableField("entryDay")
    private Date entryday;

    @ApiModelProperty(value = "在职状态")
    private Integer status;

    @ApiModelProperty(value = "离职日期")
    @TableField("outDay")
    private Date outday;

    @ApiModelProperty(value = "所属公司")
    private String company;

    @TableField("phoneNum")
    private String phonenum;

    @Version
    private Integer version;

    @TableField(fill = FieldFill.INSERT)
    private Date gtmCreate;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date gtmModify;

    @TableLogic
    private Integer deleted;


}
