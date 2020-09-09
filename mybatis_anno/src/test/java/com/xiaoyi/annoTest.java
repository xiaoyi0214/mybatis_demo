package com.xiaoyi;

import com.xiaoyi.dao.OrderMapper;
import com.xiaoyi.dao.UserMapper;
import com.xiaoyi.domain.Order;
import com.xiaoyi.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Created by 小逸 on 2020/9/9.
 *
 * @author 小逸
 */
public class annoTest {

    private SqlSession sqlSession;


    @Before
    public void init() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        System.out.println("初始化sqlSession。。。");

        sqlSession = sqlSessionFactory.openSession(true);
    }

    @After
    public void destory(){
        System.out.println("销毁sqlSession。。。");
        sqlSession.close();
    }

    @Test
    public void saveTest(){
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setId(4l);
        user.setUsername("anno");
        user.setPassword("12345");

        userMapper.save(user);

    }

    @Test
    public void selectTest(){
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = userMapper.findAll();

        for (User user : userList) {
            System.out.println(user);
        }
    }

    @Test
    public void updateTest(){
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        User user = new User();
        user.setId(4l);
        user.setUsername("anno");
        user.setPassword("123");

        userMapper.updateById(user);
    }

    @Test
    public void deleteTest(){
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        int i = userMapper.deleteById(4l);
        System.out.println(i);

    }

    @Test
    public void oneToOneTest(){
        OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);

        List<Order> orderList = orderMapper.findOrderAndUserAll();
        for (Order order : orderList) {
            System.out.println(order);
        }
    }

    @Test
    public void oneToNTest(){
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        List<User> userList = userMapper.findUserOrderAll();
        for (User user : userList) {
            System.out.println(user);
        }
    }

    @Test
    public void nToNTest(){
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        List<User> userList = userMapper.findUserAllRole();
        for (User user : userList) {
            System.out.println(user);
        }
    }





}
