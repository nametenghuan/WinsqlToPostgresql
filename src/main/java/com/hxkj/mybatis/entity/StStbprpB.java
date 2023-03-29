package com.hxkj.mybatis.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.sql.Date;

@Data
@EqualsAndHashCode(callSuper = false)
@TableName("ST_STBPRP_B")
public class StStbprpB {

    private static final long serialVersionUID = 1L;

    String stcd;

    String stnm;

    String rvnm;

    String hnnm;

    String bsnm;

    BigDecimal lgtd;

    BigDecimal lttd;

    String stlc;

    String addvcd;

    String dtmnm;

    BigDecimal dtmel;

    BigDecimal dtpr;

    String sttp;

    String frgrd;

    String esstym;

    String bgfrym;

    String atcunit;

    String admautu;

    String locality;

    String stbk;

    BigDecimal stazt;

    BigDecimal dstrvm;

    BigDecimal drna;

    String phcd;

    String usfl;

    String comments;

    Date moditime;
}
