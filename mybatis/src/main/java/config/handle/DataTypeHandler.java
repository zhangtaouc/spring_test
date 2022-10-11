package config.handle;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class DataTypeHandler extends BaseTypeHandler<Date> {
    // 将java类型转换为数据库需要的
    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, Date date, JdbcType jdbcType) throws SQLException {
        Long time = date.getTime();
        preparedStatement.setLong(i, time);
    }

    // 数据库中的类型转换为Java类型
    // s:要转换的字段名称
    // resultSet: 查询出的结果集
    @Override
    public Date getNullableResult(ResultSet resultSet, String s) throws SQLException {
        // 获得结果集中需要的数据转换成date返回
        long along = resultSet.getLong(s);
        Date date = new Date(along);
        return date;

    }
    // 数据库中的类型转换为Java类型
    @Override
    public Date getNullableResult(ResultSet resultSet, int i) throws SQLException {
        long along = resultSet.getLong(i);
        Date date = new Date(along);
        return date;
    }
    // 数据库中的类型转换为Java类型
    @Override
    public Date getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        long along = callableStatement.getLong(i);
        Date date = new Date(along);
        return date;
    }
}
