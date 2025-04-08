package com.nuketree3.example.springhw1;

import com.nuketree3.example.springhw1.model.Student;
import com.nuketree3.example.springhw1.repositories.StudentsRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.ArrayList;
import java.util.List;


/**
 * 1. Создать spring-boot приложение с помощью ...
 * 2. Создать класс Student с полями: идентификатор, имя, название группы
 * 3. Создать контроллер, обрабатывающий запросы:
 * 3.1 GET /student/{id} - получить студента по id
 * 3.2 GET /student - получить всех студентов
 * 3.3 GET /group/{groupName}/student - получить всех студентов группы
 * 3.4 POST /student - создать студента (принимает JSON) (отладить с помощью postman)
 * 4 При старте приложения, в программе должно быть создано 5-10 студентов
 **/

@SpringBootApplication
public class SpringHw1Application {

    public static void main(String[] args) {
        ApplicationContext context =  SpringApplication.run(SpringHw1Application.class, args);

        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student(1L, "Антон", "1"));
        studentList.add(new Student(2L, "Владимир", "1"));
        studentList.add(new Student(3L, "Евгения", "1"));
        studentList.add(new Student(4L, "Владислав", "2"));
        studentList.add(new Student(5L, "Николай", "2"));
        studentList.add(new Student(6L, "Анастасия", "3"));
        studentList.add(new Student(7L, "Дария", "4"));
        studentList.add(new Student(8L, "Николай", "4"));
        studentList.add(new Student(9L, "Артем", "5"));

        StudentsRepository studentsRepository = context.getBean(StudentsRepository.class);
        studentsRepository.setStudentsList(studentList);
    }

}
