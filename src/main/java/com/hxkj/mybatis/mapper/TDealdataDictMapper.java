package com.hxkj.mybatis.mapper;

import com.hxkj.mybatis.entity.TDealdataDict;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author pht
 * @since 2023-03-21
 */
public interface TDealdataDictMapper {

    TDealdataDict getTDD(@Param("tddArea") String tddArea, @Param("tddDataType") String tddDataType);
    TDealdataDict getSuiZhouTDD();

    List<Map> getAllTDD();
}
