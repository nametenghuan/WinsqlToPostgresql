package com.hxkj.mybatis.mapper;

import com.hxkj.mybatis.entity.StPptnR;
import com.hxkj.mybatis.entity.SuizhouHydrologyData;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 随州水文数据表 Mapper 接口
 * </p>
 *
 * @author pht
 * @since 2023-03-21
 */
public interface SuizhouHydrologyDataMapper {

    List<SuizhouHydrologyData> getAllSuizhouData();

    /**
     * 插入一条数据
     * @param stPptnR
     * @return
     */
    int insert(StPptnR stPptnR);
}
