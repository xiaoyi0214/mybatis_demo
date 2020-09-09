package com.xiaoyi.dao;

import com.xiaoyi.domain.Role;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by 小逸 on 2020/9/9.
 *
 * @author 小逸
 */
public interface RoleMapper {

    @Select("select * from role r left join user_role ur on r.id=ur.role_id where ur.user_id=#{uid}")
    List<Role> findByUid(int uid);


}
