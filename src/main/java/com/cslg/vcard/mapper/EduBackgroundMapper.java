package com.cslg.vcard.mapper;

import com.cslg.vcard.entity.Awards;
import com.cslg.vcard.entity.EduBackground;
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
public interface EduBackgroundMapper extends BaseMapper<EduBackground> {
    List<EduBackground> queryEduBackground(@Param("eid") String eid);
}
