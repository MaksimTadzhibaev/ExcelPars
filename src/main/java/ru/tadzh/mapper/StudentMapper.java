package ru.tadzh.mapper;

import org.springframework.jdbc.core.RowMapper;
import ru.tadzh.dto.StudentDto;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentMapper implements RowMapper<StudentDto> {
    @Override
    public StudentDto mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new StudentDto(
                rs.getLong("ID"),
                rs.getInt("AGE")
        );
    }
}
