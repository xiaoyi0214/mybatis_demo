package com.xiaoyi.dao;

import com.xiaoyi.domain.School;

import java.util.List;

/**
 * 测试 Dao 接口方式
 *
 * 1、手动实现 SchoolMapperImpl ：创建SQLSession 并手动管理
 *
 * 2、动态代理实现： 有mybatis框架根据接口定义自动创建接口的动态代理对象，代理对象的方法体同Dao接口实现类的方法
 *          遵守规则：
 *              1、Mapper.xml 文件中的namespace与mapper接口的全限定名相同！！！
 *              2、Mapper接口方法名与Mapper.xml中每个statement的id相同
 *              3、Mapper接口方法输入参数类型和Mapper.xml中定义的parameterType类型相同
 *              4、Mapper接口方法输出参数类型和Mapper.xml中定义的resultType类型相同
 *
 *
 */
public interface SchoolMapper {

    public List<School> selectAll();

    public School selectById(Long id);





}
