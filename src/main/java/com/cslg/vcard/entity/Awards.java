package com.cslg.vcard.entity;

import com.baomidou.mybatisplus.annotation.*;

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
@ApiModel(value="奖项", description="")
public class Awards implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "奖项id")
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private String id;

    @ApiModelProperty(value = "奖项信息")
    private String awardsInfo;

    @ApiModelProperty(value = "名片id")
    private String eid;

    @TableLogic
    @TableField(fill = FieldFill.INSERT)
    @ApiModelProperty(value = "逻辑删除（0 未删除、1 删除）")
    private Integer delFlag;


}
