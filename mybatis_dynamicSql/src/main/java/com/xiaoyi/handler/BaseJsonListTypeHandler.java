package com.xiaoyi.handler;

import org.apache.commons.collections.CollectionUtils;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.springframework.util.CollectionUtils;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

public class BaseJsonListTypeHandler<T> extends BaseTypeHandler<List<T>> {

    private Class<T> type;

    public BaseJsonListTypeHandler(Class<T> type) {
        if (type == null){
            throw new IllegalArgumentException("type argument cannot be null");
        }
        this.type = type;
    }

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, List<T> parameter, JdbcType jdbcType) throws SQLException {
        try{
            if (CollectionUtils.isEmpty(parameter)){
                parameter = Collections.emptyList();
            }
            String jsonStr = JSON
        }

    }

    @Override
    public List<T> getNullableResult(ResultSet resultSet, String s) throws SQLException {
        return null;
    }

    @Override
    public List<T> getNullableResult(ResultSet resultSet, int i) throws SQLException {
        return null;
    }

    @Override
    public List<T> getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        return null;
    }
}
