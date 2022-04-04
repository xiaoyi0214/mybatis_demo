package com.xiaoyi.handler;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Locale;

public class LocaleTypeHandler extends BaseTypeHandler<Locale> {
    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, Locale locale, JdbcType jdbcType) throws SQLException {
        preparedStatement.setString(i,locale.toLanguageTag());
    }

    @Override
    public Locale getNullableResult(ResultSet resultSet, String s) throws SQLException {
        String language = resultSet.getString(s);
        return Locale.forLanguageTag(language);
    }

    @Override
    public Locale getNullableResult(ResultSet resultSet, int i) throws SQLException {
        return null;
    }

    @Override
    public Locale getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        return null;
    }
}
