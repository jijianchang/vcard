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
@ApiModel(value="Primary对象", description="")
public class Primary implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "预选单编号")
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private String id;

    @ApiModelProperty(value = "最大选择数量")
    private String maxChoice;

    @ApiModelProperty(value = "用户id")
    private String uid;

    @ApiModelProperty(value = "名片id")
    private String eid;

    @TableLogic
    @TableField(fill = FieldFill.INSERT)
    @ApiModelProperty(value = "逻辑删除（0 未删除、1 删除）")
    private Integer delFlag;


}
