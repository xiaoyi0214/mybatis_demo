package com.xiaoyi;

import com.xiaoyi.dao.StudentMapper;
import com.xiaoyi.domain.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

/**
 * 测试Date类型转换为Long类型存储
 * Created by 小逸 on 2020/9/8.
 *
 * @author 小逸
 */
public class typeHandlerTest {

    @Test
    public void dateToLongTypeHandlerTest() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);

        Student student = new Student();

        student.setId(1l);
        student.setName("董OG");
        student.setBirthday(new Date());

        studentMapper.save(student);

        sqlSession.commit();
        sqlSession.close();

    }
    @Test
    public void dateToLongTypeHandlerTest1() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);

        List<Student> studentList = studentMapper.findAll();
        System.out.println(studentList);

        sqlSession.commit();
        sqlSession.close();

    }
}
