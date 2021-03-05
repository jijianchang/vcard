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
@ApiModel(value="Paper对象", description="")
public class Paper implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "论文id")
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private String id;

    @ApiModelProperty(value = "论文类型")
    private String type;

    @ApiModelProperty(value = "论文信息")
    private String info;

    @ApiModelProperty(value = "名片id")
    private String eid;

    @TableLogic
    @TableField(fill = FieldFill.INSERT)
    @ApiModelProperty(value = "逻辑删除（0 未删除、1 删除）")
    private Integer delFlag;


}
