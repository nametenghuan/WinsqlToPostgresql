package com.hxkj.mybatis.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 随州水文数据表
 * </p>
 *
 * @author pht
 * @since 2023-03-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class SuizhouHydrologyData implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 时间段降水量
     */
    @TableId(value = "drp_densty", type = IdType.AUTO)
    private BigDecimal drpDensty;

    /**
     * 时段长
     */
    private String intvDensty;

    /**
     * 降水历时
     */
    private String pdrDensty;

    /**
     * 日降水量
     */
    private BigDecimal dypDensty;

    /**
     * 天气状况
     */
    private String wthDensty;

    /**
     * 区站号
     */
    private String stationIdC;

    /**
     * 资料时间
     */
    private String datetime;


}
