package com.hxkj.mybatis.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableName;
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
@TableName("t_dealdata_dict")
public class TDealdataDict implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "tdd_id", type = IdType.AUTO)
    Integer id;
    @TableField("tdd_pid")
    Integer pid;
    @TableField("tdd_area")
    String area;
    @TableField("tdd_data_type")
    String dataType;
    @TableField("tdd_save_type")
    Integer saveType;
    @TableField("tdd_org_path")
    String orgPath;
    @TableField("tdd_data_path")
    String dataPath;
    @TableField("tdd_filename_rule")
    String fileNameRule;
    @TableField("tdd_flat")
    Double fLat;
    @TableField("tdd_tlat")
    Double tLat;
    @TableField("tdd_flon")
    Double fLon;
    @TableField("tdd_tlon")
    Double tLon;
    @TableField("tdd_diff")
    Double tDiff;
    @TableField("tdd_newtime")
    Date newTime;
    @TableField("tdd_eles")
    String eles;

    /**
     * 补充的2个字段
     * @author pht
     * @since 2022-06-23
     */

    /**
     * 所属工程的id
     */
    @TableField("tdd_project_id")
    private String tddProjectId;

    /**
     * 所属产品的id
     */
    @TableField("tdd_product_id")
    private String tddProductId;


}
