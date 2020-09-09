package com.xiaoyi;

import com.xiaoyi.dao.UserMapper;
import com.xiaoyi.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 小逸 on 2020/9/8.
 *
 * @author 小逸
 */
public class DynamicSqlTest {

    @Test
    public void userConditionTest() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setId(1l);
//        user.setUsername("张三");
        // 去除后   select * from user where id = #{id} and username = #{username} and password = #{password}; 有问题
        // 需使用动态sql if 做判断
        // user.setPassword("123");

        List<User> userList = userMapper.selectByCondition(user);
        System.out.println(userList);

        sqlSession.close();
    }
    @Test
    public void userForEachTest() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        List<Long> ids = new ArrayList<>();
        ids.add(1l);
        ids.add(2l);
        List<User> userList = userMapper.selectByIds(ids);
        System.out.println(userList);

        sqlSession.close();
    }
}
