package com.xiaoyi.dao;

import com.xiaoyi.domain.User;

import java.util.List;

public interface UserMapper {

    public List<User> selectByCondition(User user);

    public List<User> selectByIds(List<Long> ids);


}
