package com.example.practice.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface RowMapper {
    Object map(ResultSet resultSet) throws SQLException;
}
