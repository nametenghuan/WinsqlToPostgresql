package com.hxkj.mybatis.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author pht
 * @since 2023-03-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("ST_PPTN_R")
public class StPptnR implements Serializable {

    private static final long serialVersionUID = 1L;

    String stcd;
    Date tm;
    BigDecimal drp;
    BigDecimal intv;
    BigDecimal pdr;
    BigDecimal dyp;
    String wth;

}
