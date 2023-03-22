package com.hxkj.mybatis.text;

import com.hxkj.mybatis.Utils.SqlSessionUtil;
import com.hxkj.mybatis.entity.StPptnR;
import com.hxkj.mybatis.entity.SuizhouHydrologyData;
import com.hxkj.mybatis.entity.TDealdataDict;
import com.hxkj.mybatis.mapper.StPptnRMapper;
import com.hxkj.mybatis.mapper.SuizhouHydrologyDataMapper;
import com.hxkj.mybatis.mapper.TDealdataDictMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

/**
 * 要尊重编程
 *
 * @Author: 庞欢腾
 * @Date: 2023/3/21
 * @Description: mybatis
 */
public class SuizhouTest {

    @Test
    public void maintest() {
        try {
            test();
            testWR();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test() throws IOException {

        InputStream resource = Resources.getResourceAsStream("mybaties-config-pg.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(resource);
        // .openSession(true) 传入true参数表示自动提交事务
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        SuizhouHydrologyDataMapper suizhouHydrologyDataMapper = sqlSession.getMapper(SuizhouHydrologyDataMapper.class);

        List<SuizhouHydrologyData> allSuizhouData = suizhouHydrologyDataMapper.getAllSuizhouData();
        // 插入数据时需要提交事务
//        sqlSession.commit();
        for (SuizhouHydrologyData data : allSuizhouData) {
            System.out.println(data);
        }
    }
    @Test
    public void test2() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession("mybaties-config-pg.xml");

        SuizhouHydrologyDataMapper suizhouHydrologyDataMapper = sqlSession.getMapper(SuizhouHydrologyDataMapper.class);
        List<SuizhouHydrologyData> allSuizhouData = suizhouHydrologyDataMapper.getAllSuizhouData();

        for (SuizhouHydrologyData data : allSuizhouData) {
            System.out.println(data);
        }
    }

    @Test
    public void testWR() throws IOException {
        InputStream resource = Resources.getResourceAsStream("mybaties-config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(resource);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        StPptnRMapper stPptnR = sqlSession.getMapper(StPptnRMapper.class);

        List<StPptnR> stPptnRS = stPptnR.getsrAll();
        // 插入数据时需要提交事务
        sqlSession.commit();
        for (StPptnR data : stPptnRS) {
            System.out.println(data);
        }
    }

    @Test
    public void testTDD() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession("mybaties-config-pg.xml");
        TDealdataDictMapper mapper = sqlSession.getMapper(TDealdataDictMapper.class);
//        TDealdataDict tDealdataDict = mapper.getTDD("suizhou", "hydrology_data");
//        System.out.println(tDealdataDict);

        /*List<Map> allTDD = mapper.getAllTDD();
        for (Map dict : allTDD) {
            System.out.println(dict);
        }*/

        TDealdataDict suiZhouTDD = mapper.getSuiZhouTDD();
        System.out.println(suiZhouTDD);

    }
}
