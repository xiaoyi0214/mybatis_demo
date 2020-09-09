package com.xiaoyi;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xiaoyi.dao.StudentMapper;
import com.xiaoyi.domain.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Created by 小逸 on 2020/9/8.
 *
 * @author 小逸
 */
public class PageHelperTest {

    @Test
    public void pageHelperTest() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);

        // 设置分页相关参数
        PageHelper.startPage(2, 3);

        List<Student> studentList = studentMapper.findAll();

        for (Student student : studentList){
            System.out.println(student);
        }

        // 获取与分页相关数据

        PageInfo<Student> pageInfo = new PageInfo<Student>(studentList);
        System.out.println("当前页"+pageInfo.getPageNum());
        System.out.println("每页显示条数"+pageInfo.getPageSize());
        System.out.println("总条数"+pageInfo.getTotal());
        System.out.println("总页数"+pageInfo.getPages());
        System.out.println("上一页"+pageInfo.getPrePage());
        System.out.println("下一页"+pageInfo.getNextPage());
        System.out.println("是否第一页"+pageInfo.isIsFirstPage());
        System.out.println("是否最后页"+pageInfo.isIsLastPage());


        sqlSession.commit();
        sqlSession.close();

    }


}
