package com.cslg.vcard.entity;

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
 * @author jjc
 * @since 2021-03-05
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="Ecard对象", description="")
public class Ecard implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "名片id")
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private String id;

    @ApiModelProperty(value = "姓名")
    private String ename;

    @ApiModelProperty(value = "性别")
    private String egender;

    @ApiModelProperty(value = "年龄")
    private String eage;

    @ApiModelProperty(value = "学院")
    private String ecollege;

    @ApiModelProperty(value = "民族")
    private String enation;

    @ApiModelProperty(value = "E-mail")
    private String email;

    @ApiModelProperty(value = "籍贯")
    private String enative;

    @ApiModelProperty(value = "教研室")
    private String eteachOffice;

    @ApiModelProperty(value = "职称")
    private String eprofessionalTitle;

    @ApiModelProperty(value = "照片")
    private String eimg;

    @ApiModelProperty(value = "用户id")
    private String uid;

    @TableLogic
    @TableField(fill = FieldFill.INSERT)
    @ApiModelProperty(value = "逻辑删除（0 未删除、1 删除）")
    private Integer delFlag;

    @ApiModelProperty(value = "审核（0：未审核，1：审核）")
    private String audit;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "更新时间")
    private Date updateTime;


}
