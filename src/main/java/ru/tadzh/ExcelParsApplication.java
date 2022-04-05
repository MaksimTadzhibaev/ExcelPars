package ru.tadzh;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import ru.tadzh.repository.StudentRepository;

@SpringBootApplication
public class ExcelParsApplication {

    @Autowired
    StudentRepository studentRepository;

    public static void main(String[] args) {
        SpringApplication.run(ExcelParsApplication.class, args);
    }

//    @EventListener(ApplicationReadyEvent.class)
//    public void testMethods(){
//        System.out.println(studentRepository.findAll());
//    }

}
