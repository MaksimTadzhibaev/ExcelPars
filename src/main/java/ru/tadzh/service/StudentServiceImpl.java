package ru.tadzh.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.tadzh.dto.StudentDto;
import ru.tadzh.entity.Student;
import ru.tadzh.repository.StudentRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService{

    StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<StudentDto> findAll() {
        return studentRepository.findAll().stream()
                .map(student -> new StudentDto(student.getId(), student.getName(), student.getAge()))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<StudentDto> findById(Long id) {
        return studentRepository.findById(id)
                .map(student -> new StudentDto(student.getId(), student.getName(), student.getAge()));
    }


    @Override
    public void save(StudentDto studentDto) {
        Student student = new Student(studentDto.getId(), studentDto.getName(), studentDto.getAge());
        studentRepository.save(student);
    }

    @Override
    public void deleteById(Long id) {
        studentRepository.deleteById(id);
    }
}
