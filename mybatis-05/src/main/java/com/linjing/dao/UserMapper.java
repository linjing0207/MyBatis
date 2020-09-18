package com.linjing.dao;

import com.linjing.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserMapper {

    //查询全部用户
    @Select("select * from user") List<User> getUserList();

    //方法存在多个参数，所有的参数前面必须加上@Param("id")注解
    @Select("select * from user where id = #{id} and name = #{name}") User getUserById(@Param("id") int id,
        @Param("name") String name);
    //@Param("") 基本类型加上这个，引用类型不用加
    //#{id} 对应 @Param("id")

    @Insert("insert into user (id, name, pwd) values (#{id}, #{name}, #{pwd})") int addUser(
        User user); //引用类型，不用加@param()

    @Update("update user set name = #{name}, pwd = #{pwd} where id = #{id}") int updateUser(User user);

    @Delete("delete from user where id = #{uid}") int deleteUser(@Param("uid") int id);
}
