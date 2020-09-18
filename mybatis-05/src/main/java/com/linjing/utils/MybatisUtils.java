package com.linjing.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

//sqlSessionFactory -> sqlSession
public class MybatisUtils {

    private static SqlSessionFactory sqlSessionFactory;

    //一初始就加载
    static {
        InputStream in = null;
        try {
            //1. 使用mybatis获得sqlSessionFactory对象
            in = Resources.getResourceAsStream("mybatis-config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //既然有了 SqlSessionFactory，顾名思义，我们可以从中获得 SqlSession 的实例。
    //SqlSession 提供了在数据库执行 SQL 命令所需的所有方法。你可以通过 SqlSession 实例来直接执行已映射的 SQL 语句。
    //SqlSession可以执行sql操作
    public static SqlSession getSqlSession() {
        return sqlSessionFactory.openSession(true); //设置自动提交，autoCommit = true
    }
}
