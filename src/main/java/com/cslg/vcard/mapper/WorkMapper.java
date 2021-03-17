package com.cslg.vcard.mapper;

import com.cslg.vcard.entity.TeachCource;
import com.cslg.vcard.entity.Work;
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
public interface WorkMapper extends BaseMapper<Work> {
    List<Work> queryWork(@Param("eid") String eid);

}
