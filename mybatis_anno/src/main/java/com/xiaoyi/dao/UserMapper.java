package com.xiaoyi.dao;

import com.xiaoyi.domain.Order;
import com.xiaoyi.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by 小逸 on 2020/9/8.
 *
 * @author 小逸
 */
public interface UserMapper {


    @Insert("insert into user values (#{id},#{username},#{password})")
    void save(User user);

    @Select("select * from `user`")
    @Results({
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "username", property = "username"),
            @Result(column = "password", property = "password")
    })
    List<User> findAll();

    @Update("update user set username = #{username}, password = #{password} where id = #{id}")
    void updateById(User user);

    @Delete("delete from user where id = #{id}")
    int deleteById(Long id);

    @Select("select * from user where id = #{id}")
    @Results({
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "username", property = "username"),
            @Result(column = "password", property = "password")
    })
    User findById(Long id);

    @Select("select * from `user`")
    @Results({
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "username", property = "username"),
            @Result(column = "password", property = "password"),
            @Result(column = "id", property = "orderList", javaType = List.class, many=@Many(select = "com.xiaoyi.dao.OrderMapper.findUserOrders"))

    })
    List<User> findUserOrderAll();

    @Select("select * from `user`")
    @Results({
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "username", property = "username"),
            @Result(column = "password", property = "password"),
            @Result(column = "id", property = "roleList", javaType = List.class, many=@Many(select = "com.xiaoyi.dao.RoleMapper.findByUid"))

    })
    List<User> findUserAllRole();





}
