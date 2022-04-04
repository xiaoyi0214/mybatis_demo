package com.xiaoyi.test;

import com.xiaoyi.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

/**
 * Created by 小逸 on 2020/9/7.
 *
 * @author 小逸
 */
public class MyBatisTest {

    private static SqlSessionFactory sqlSessionFactory;

    // 静态抽取
    static {
        // 获取核心配置文件
        InputStream resourceAsStream = null;
        try {
            resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 获取session工厂对象
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
    }

    @Test
    public void test1() throws IOException {

        // 获取核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        // 获取session工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        // 获取session会话对象
//        SqlSession sqlSession = sqlSessionFactory.openSession(true);//开启自动提交
        SqlSession sqlSession = sqlSessionFactory.openSession();//默认开启事务，必须手动提交
        // 执行操作
        // userMapper.selectAll  --> userMapper 为mapper 的namespace
        //                       --> selectAll 为SQL 的id
        List<User> userList = sqlSession.selectList("userMapper.selectAll");

        System.out.println(userList);

        sqlSession.close();

    }

    @Test
    public void testSave() {
        User user = new User();
        user.setId(2L);
        user.setUsername("王五");
        user.setPassword("123");

        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 执行操作  userMapper.save
        int i = sqlSession.insert("userMapper.save",user);// rows = statement.getUpdateCount(); 默认返回值为影响数据的条数

        // 插入操作必须手动提交事务
        sqlSession.commit();// sqlSession.rollback();

        sqlSession.close();
    }

    @Test
    public void testUpdate() {
        SqlSession sqlSession = sqlSessionFactory.openSession();

        User user = sqlSession.selectOne("userMapper.selectById", 1l);
        System.out.println(user);
        user.setUsername("lucy");
        // 执行操作  userMapper.save
        int i = sqlSession.update("userMapper.updateById", user);// rows = statement.getUpdateCount(); 默认返回值为影响数据的条数
        System.out.println(i);
        // 更新操作必须手动提交事务
        sqlSession.commit();

        sqlSession.close();
    }
    @Test
    public void testDelete() {
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 执行操作  userMapper.delete
        int i = sqlSession.delete("userMapper.deleteById",5L);// rows = statement.getUpdateCount(); 默认返回值为影响数据的条数
        System.out.println(i);
        // 删除操作必须手动提交事务
        sqlSession.commit();

        sqlSession.close();
    }



}
