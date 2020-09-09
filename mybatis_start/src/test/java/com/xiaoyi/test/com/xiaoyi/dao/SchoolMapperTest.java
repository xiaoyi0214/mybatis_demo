package com.xiaoyi.test.com.xiaoyi.dao;

import com.xiaoyi.dao.SchoolMapper;
import com.xiaoyi.dao.impl.SchoolMapperImpl;
import com.xiaoyi.domain.School;
import com.xiaoyi.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Created by 小逸 on 2020/9/7.
 *
 * @author 小逸
 */
public class SchoolMapperTest {

    @Test
    public void testSeleteAll(){
        // 当前Dao 的实现是手动实现的
        SchoolMapper schoolMapper = new SchoolMapperImpl();
        List<School> schoolList = schoolMapper.selectAll();
        System.out.println(schoolList);
    }

    @Test
    public void testSchoolSelectAllProxy() throws IOException {

        // 获取核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        // 获取session工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        // 获取session会话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();//默认开启事务，必须手动提交

        SchoolMapper mapper = sqlSession.getMapper(SchoolMapper.class);
        List<School> schools = mapper.selectAll();
        System.out.println(schools);
    }
    @Test
    public void testSchoolSelectByIdroxy() throws IOException {

        // 获取核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        // 获取session工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        // 获取session会话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();//默认开启事务，必须手动提交

        SchoolMapper mapper = sqlSession.getMapper(SchoolMapper.class);
        School school = mapper.selectById(1l);
        System.out.println(school);
    }


}
