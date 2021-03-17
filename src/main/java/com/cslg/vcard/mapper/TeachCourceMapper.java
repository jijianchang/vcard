package com.cslg.vcard.mapper;

import com.cslg.vcard.entity.StudyDirection;
import com.cslg.vcard.entity.TeachCource;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author jjc
 * @since 2021-03-05
 */
public interface TeachCourceMapper extends BaseMapper<TeachCource> {
    List<TeachCource> queryTeachCource(@Param("eid") String eid);
}
