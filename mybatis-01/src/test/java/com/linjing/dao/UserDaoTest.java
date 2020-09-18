package com.linjing.dao;

import com.linjing.pojo.User;
import com.linjing.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class UserDaoTest {

    @Test public void testGetUserList() {

        SqlSession session = null;
        try {
            //1. 获得sqlSession对象
            session = MybatisUtils.getSqlSession();

            //方式一：getMapper（推荐使用），类型更加安全
            UserMapper mapper = session.getMapper(UserMapper.class);
            List<User> userList = mapper.getUserList();

            //方式二：原来的方式（不推荐使用）
            //        List<User> userList = sqlSession.selectList("com.linjing.dao.UserDao.getUserList");

            for (User user : userList) {
                System.out.println(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //关闭sqlSession
            session.close();
        }
    }

    @Test public void testGetUserById() {
        SqlSession session = MybatisUtils.getSqlSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        User user = mapper.getUserById(1);
        System.out.println(user);

        session.close();
    }

    //增删改，需要提交事物
    @Test public void testAddUser() {

        SqlSession session = MybatisUtils.getSqlSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        int n = mapper.addUser(new User(4, "lily", "2333"));
        if (n > 0) {
            System.out.println("插入成功");
        }

        //提交事物
        session.commit(); //很重要！！不写提交不了。
        session.close();
    }

    //修改用户
    @Test public void testUpdateUser() {

        SqlSession session = MybatisUtils.getSqlSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        int n = mapper.updateUser(new User(4, "linda", "999"));
        if (n > 0) {
            System.out.println("修改成功");
        }

        //提交事物
        session.commit(); //很重要！！不写提交不了。
        session.close();
    }

    //修改用户
    @Test public void testDeleteUser() {

        SqlSession session = MybatisUtils.getSqlSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        mapper.deleteUser(4);

        //提交事物
        session.commit(); //很重要！！不写提交不了。
        session.close();
    }
}
