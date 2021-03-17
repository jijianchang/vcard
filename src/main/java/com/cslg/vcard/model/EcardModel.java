package com.cslg.vcard.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.cslg.vcard.entity.*;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @Description: 名片表
 * @Author: jeecg-boot
 * @Date:   2021-02-22
 * @Version: V1.0
 */
@Data
@TableName("ecard")
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="ecard对象", description="名片表")
public class EcardModel extends Ecard {
    private List<Awards> awards;
    private List<EduBackground> eduBackgrounds;
    private List<Paper> papers;
    private List<Work> works;
    private List<StudyDirection> studyDirections;
    private List<TeachCource> teachCources;

}
