package ru.tadzh.service;

import ru.tadzh.dto.StudentDto;

import java.util.List;
import java.util.Optional;

public interface StudentService {

    List<StudentDto> findAll();

    Optional<StudentDto> findById(Long id);

    void save(StudentDto studentDto);

    void deleteById(Long id);
}

