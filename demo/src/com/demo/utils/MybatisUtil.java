package com.demo.utils;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author : whc
 * @Project: demo
 * @Package com.ssm.utils
 * @Description: Mybatis工具类
 * @date Date : 2020年04月12日 15:05
 */
public class MybatisUtil {

    private static ThreadLocal<SqlSession> threadLocal = new ThreadLocal<SqlSession>();

    @Autowired
    private static SqlSessionFactory sqlSessionFactory;

    private MybatisUtil() {
    }

    public static SqlSession getSqlSession() {
        SqlSession sqlSession = threadLocal.get();
        if (sqlSession == null) {
            //关闭自动提交，改为手动提交模式
            sqlSession = sqlSessionFactory.openSession(false);
            threadLocal.set(sqlSession);
        }
        return sqlSession;
    }

    public static void closeSqlSession() {
        SqlSession sqlSession = threadLocal.get();
        if (sqlSession != null) {
            sqlSession.close();
            threadLocal.remove();
        }
    }

}
