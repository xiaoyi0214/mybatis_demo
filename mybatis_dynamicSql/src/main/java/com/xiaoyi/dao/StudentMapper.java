package com.xiaoyi.dao;

import com.xiaoyi.domain.Student;

import java.util.List;

/**
 * Created by 小逸 on 2020/9/8.
 *
 * @author 小逸
 */
public interface StudentMapper {

    public void save(Student student);

    public List<Student> findAll();

}
