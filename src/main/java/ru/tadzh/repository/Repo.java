package ru.tadzh.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.tadzh.dto.StudentDto;
import ru.tadzh.mapper.StudentMapper;

import java.util.List;

@Repository
public class Repo {
    @Autowired
    NamedParameterJdbcTemplate jdbcTemplate;

    public List<StudentDto> getStudents (){
        String queryString =
                "select id, age " +
                        "from students.student";
        return jdbcTemplate.query(queryString, new StudentMapper());
    }
}
