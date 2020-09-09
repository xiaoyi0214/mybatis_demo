package com.xiaoyi.handler;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**
 * Created by 小逸 on 2020/9/8.
 *
 * @author 小逸
 *
 * 自定义类型转换处理器：
 *      1、定义转换类继承BaseTypeHandler 或者实现 TypeHander接口
 *      2、实现四个方法
 *      3、mybatis核心配置文件中注册
 *
 *
 */
public class DateTypeHandler extends BaseTypeHandler<Date> {
    // 将java类型转换成数据库需要的类型
    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, Date parameter, JdbcType jdbcType) throws SQLException {
        long time = parameter.getTime();
        ps.setLong(i,time);
    }

    // 将数据库中的类型转换成java类型
    @Override
    public Date getNullableResult(ResultSet rs, String columnName) throws SQLException {
        // 获取结果集中需要的数据，转换成需要的类型
        long aLong = rs.getLong(columnName);
        Date date = new Date(aLong);
        return date;
    }

    // 将数据库中的类型转换成java类型
    @Override
    public Date getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        // 获取结果集中需要的数据，转换成需要的类型
        long aLong = rs.getLong(columnIndex);
        Date date = new Date(aLong);
        return date;
    }

    // 将数据库中的类型转换成java类型
    @Override
    public Date getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        long aLong = cs.getLong(columnIndex);
        Date date = new Date(aLong);
        return date;
    }
}
