package com.xiaoyi.dao;

import com.xiaoyi.domain.Order;
import com.xiaoyi.domain.User;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by 小逸 on 2020/9/8.
 *
 * @author 小逸
 */
public interface OrderMapper {

    /* one to one
    * */

    @Select("select o.*,u.username,u.password from `order` o left join `user` u on o.user = u.id ")
    @Results({
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "order_no", property = "orderNo"),
            @Result(column = "price", property = "price"),
            @Result(column = "user", property = "user", javaType = User.class, one = @One(select = "com.xiaoyi.dao.UserMapper.findById"))

    })
    List<Order> findOrderAndUserAll();


    @Select("select * from `order` where user = #{userId}")
    @Results({
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "order_no", property = "orderNo"),
            @Result(column = "price", property = "price"),
    })
    List<Order> findUserOrders(Long userId);
}
