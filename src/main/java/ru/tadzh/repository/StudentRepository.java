package ru.tadzh.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.tadzh.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
