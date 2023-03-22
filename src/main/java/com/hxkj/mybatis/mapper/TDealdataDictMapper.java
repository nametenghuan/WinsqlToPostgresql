package com.hxkj.mybatis.mapper;

import com.hxkj.mybatis.entity.TDealdataDict;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
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
    Map getSuiZhouTDD();

    List<Map> getAllTDD();

    /**
     * 更新tdd最新时间
     * @param date
     * @return
     */
    int updateDateTime(Date date);
}
