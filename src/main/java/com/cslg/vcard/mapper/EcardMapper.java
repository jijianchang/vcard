package com.cslg.vcard.mapper;

import com.cslg.vcard.entity.Ecard;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cslg.vcard.model.EcardModel;
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
public interface EcardMapper extends BaseMapper<Ecard> {
    List<EcardModel> queryEcardList(@Param("id") String id);
}
