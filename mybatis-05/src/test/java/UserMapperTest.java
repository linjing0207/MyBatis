import com.linjing.dao.UserMapper;
import com.linjing.pojo.User;
import com.linjing.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class UserMapperTest {

    @Test public void testGetUserList() {
        SqlSession session = MybatisUtils.getSqlSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        List<User> userList = mapper.getUserList();
        for (User user : userList) {
            System.out.println(user);
        }
        session.close();
    }

    @Test public void testGetUserById() {
        SqlSession session = MybatisUtils.getSqlSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        User u = mapper.getUserById(1, "lulu");
        System.out.println(u);
        session.close();
    }


    @Test public void testAddUser() {
        SqlSession session = MybatisUtils.getSqlSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        mapper.addUser(new User(7, "timi", "123"));
        //sqlSessionFactory.openSession(true);
        //设置了自动提交事务，则不需要自己手动提交了。
        session.close();
    }

    @Test public void testUpdateUser() {
        SqlSession session = MybatisUtils.getSqlSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        mapper.updateUser(new User(7, "tom", "456"));
        //sqlSessionFactory.openSession(true);
        //设置了自动提交事务，则不需要自己手动提交了。
        session.close();
    }

    @Test public void testDeleteUser() {
        SqlSession session = MybatisUtils.getSqlSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        mapper.deleteUser(7);
        //sqlSessionFactory.openSession(true);
        //设置了自动提交事务，则不需要自己手动提交了。
        session.close();
    }

}
