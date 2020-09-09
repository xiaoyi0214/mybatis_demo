package com.xiaoyi.dao.impl;

import com.xiaoyi.dao.SchoolMapper;
import com.xiaoyi.domain.School;
import com.xiaoyi.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Created by 小逸 on 2020/9/7.
 *
 * @author 小逸
 */
public class SchoolMapperImpl implements SchoolMapper {

    @Override
    public List<School> selectAll() {

/*        InputStream resourceAsStream = null;
        try {
            resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();//默认开启事务，必须手动提交

        List<School> schools = sqlSession.selectList("schoolMapper.selectAll");

        return schools;*/
        return null;
    }

    @Override
    public School selectById(Long id) {
        return null;
    }


}
