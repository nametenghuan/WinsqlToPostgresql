package com.hxkj.mybatis.mapper;

import com.hxkj.mybatis.entity.StPptnR;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author pht
 * @since 2023-03-21
 */
public interface StPptnRMapper {

    List<StPptnR> getsrAll();

    /**
     * 查询大于指定时间的数据
     * @param tdd_newtime
     * @return
     */
    List<StPptnR> getSprByDateTime(@Param("tdd_newtime") Date tdd_newtime);
}
