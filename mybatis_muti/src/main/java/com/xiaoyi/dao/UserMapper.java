package com.xiaoyi.dao;

import com.xiaoyi.domain.User;

import java.util.List;

/**
 * Created by 小逸 on 2020/9/8.
 *
 * @author 小逸
 */
public interface UserMapper {

    public List<User> findAll();

    public List<User> findUserAllRole();



}
