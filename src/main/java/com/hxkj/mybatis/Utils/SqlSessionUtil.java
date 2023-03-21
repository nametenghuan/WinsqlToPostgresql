package com.hxkj.mybatis.Utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * 要尊重编程
 *
 * @Author: 庞欢腾
 * @Date: 2023/3/21
 * @Description: mybatis
 */
public class SqlSessionUtil {
    public static SqlSession getSqlSession(String configName) {

        InputStream resource = null;
        SqlSession sqlSession = null;
        try {
            resource = Resources.getResourceAsStream(configName);
            SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
            SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(resource);
            // .openSession(true) 传入true参数表示自动提交事务
            sqlSession = sqlSessionFactory.openSession(true);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return sqlSession;
    }
}
