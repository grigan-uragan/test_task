package ru.ucscards.test_task.model;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DataMapper implements RowMapper<Data> {
    @Override
    public Data mapRow(ResultSet resultSet, int i) throws SQLException {
        Data data = new Data();
        data.setId(resultSet.getInt("id"));
        data.setValue(resultSet.getString("value"));
        return data;
    }
}
