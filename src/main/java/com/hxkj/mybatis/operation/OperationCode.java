package com.hxkj.mybatis.operation;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.hxkj.mybatis.Utils.RedisUtil;
import com.hxkj.mybatis.Utils.SqlSessionUtil;
import com.hxkj.mybatis.entity.StPptnR;
import com.hxkj.mybatis.mapper.StPptnRMapper;
import com.hxkj.mybatis.mapper.SuizhouHydrologyDataMapper;
import com.hxkj.mybatis.mapper.TDealdataDictMapper;
import org.apache.ibatis.session.SqlSession;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 要尊重编程
 *
 * @Author: 庞欢腾
 * @Date: 2023/3/22
 * @Description: mybatis
 */
public class OperationCode {
    SqlSession pgsqlSession = SqlSessionUtil.getSqlSession("mybaties-config-pg.xml");
    SqlSession sqlservSession = SqlSessionUtil.getSqlSession("mybaties-config.xml");

    public boolean run() {
        /**
         * 1.查询tdd获取最新时间
         */
        TDealdataDictMapper mapper = pgsqlSession.getMapper(TDealdataDictMapper.class);
        Map suiZhouTDD = mapper.getSuiZhouTDD();
        Date tdd_newtime = (Date) suiZhouTDD.get("tdd_newtime");
        System.out.println(tdd_newtime);


        /**
         * 2.查询微软数据库中是否产生了新数据
         */
        StPptnRMapper stPptnRMapper = sqlservSession.getMapper(StPptnRMapper.class);
        List<StPptnR> stPptnRList = stPptnRMapper.getSprByDateTime(tdd_newtime);

        if (CollectionUtils.isEmpty(stPptnRList) || stPptnRList.get(0) == null) {
            System.out.println("微软数据库里没有比" + tdd_newtime + "更新的数据！");
            return false;
        }
        System.out.println(stPptnRList.size());
        System.out.println(stPptnRList.get(0));


        /**
         * 3.在postgre里插入一条数据
         */
        SuizhouHydrologyDataMapper suizhouHydrologyDataMapper = pgsqlSession.getMapper(SuizhouHydrologyDataMapper.class);
        int num = 0;
        for (StPptnR r : stPptnRList) {
            try {
                // 验证将要入库的数据日期是否合法
                Date tatatm = r.getTm();

                if (tatatm.after(new Date())) {
                    System.out.println("数据最新时间不合法！" + r.getTm());
                    continue;
                }
                num += suizhouHydrologyDataMapper.insert(r);
            } catch (Exception e) {
                System.out.println("插入的数据已存在！");
            }
        }
        System.out.println("入库条数：" + num);

        // 插入成功后更新tdd最新时间
        try {
            Date date = stPptnRList.stream().map(StPptnR::getTm).max(Date::compareTo).get(); // 获取集合中最新的日期参数
            //Date date = stPptnRList.get(stPptnRList.size() - 1).getTm();
            int upd = mapper.updateDateTime(date);
            if (upd > 0) {
                System.out.println("清除redis缓存水文tdd配置数据！");
                RedisUtil.delRedisCache();
                System.out.println("tdd最新时间更新成功！");
            } else {
                System.out.println("tdd最新时间更新失败！");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return true;
    }
}
