package ru.tadzh.controller;

import org.jxls.common.Context;
import org.jxls.util.JxlsHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.tadzh.dto.StudentDto;
import ru.tadzh.repository.Repo;
import ru.tadzh.service.ExcelColorService;
import ru.tadzh.service.StudentService;

import java.io.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = {"/student"}, produces = "application/json")
public class StudentController {

    @Autowired
    private Repo repo;

    private static Logger logger = LoggerFactory.getLogger(StudentController.class);

    private StudentService studentService;

    private ExcelColorService excelColorService;

    @Autowired
    public StudentController(StudentService studentService, ExcelColorService excelColorService) {
        this.studentService = studentService;
        this.excelColorService = excelColorService;
    }

    //    Отображение страницы содержащей всю информацию про Студентов
    @GetMapping("/all")
    public List<StudentDto> allStudents() {
       return studentService.findAll();
    }

    //    Отображение страницы содержащей всю информацию про одного Студента
    @GetMapping("/{id}")
    public StudentDto getStudent(@PathVariable("id") Long id) throws Exception {
        return studentService.findById(id).orElseThrow();
    }

    //    Создание нового Студента
    @PostMapping(value = {"/new"}, consumes = "application/json")
    public StudentDto newStudent(@RequestBody StudentDto studentDto) {
       studentService.save(studentDto);
       return studentDto;
    }

    //    Редактирование Студента
    @PutMapping("/{id}/edit")
    public StudentDto editStudent(@RequestBody StudentDto studentDto, @PathVariable("id") Long id) {
        studentService.save(studentDto);
        return studentDto;
    }

    //    Удаление Студента
    @DeleteMapping("/{id}/delete")
    public void deleteStudent(@PathVariable("id") Long id) {
        studentService.deleteById(id);
    }

    //    Переносим всех студентов в excel
    @PostMapping(value = "/parseAll")
    public String parseAll() throws ParseException, IOException {
        List<StudentDto> students = studentService.findAll();
        try (InputStream is = new FileInputStream("src/main/resources/templates/studentList.xlsx")) {
            try (OutputStream os = new FileOutputStream("excel/studentList.xlsx")) {
                Context context = new Context();
                context.putVar("students", students);
                JxlsHelper.getInstance().processTemplate(is, os, context);
                excelColorService.pointCell();
                return "GOOD";
            }
        }
    }

    //    Переносим одного студента в excel
    @PostMapping(value = "/{id}/parseId")
    public String parseId(@PathVariable("id") Long id) throws ParseException, IOException {
        List<StudentDto> student = new ArrayList<>();
        student.add(studentService.findById(id).orElseThrow());
        try (InputStream is = new FileInputStream("src/main/resources/templates/studentId.xlsx")) {
            try (OutputStream os = new FileOutputStream("excel/studentId"+(id)+".xlsx")) {
                Context context = new Context();
                context.putVar("students", student);
                JxlsHelper.getInstance().processTemplate(is, os, context);
                return "GOOD";
            }
        }
    }

    @PostMapping(value = "/getStudents")
    public List<StudentDto> getStudents() {
        return repo.getStudents();
    }
}
