package com.nuketree3.example.springhw1.repositories;

import com.nuketree3.example.springhw1.model.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentsRepository {

    private List<Student> students;

    public void setStudentsList(List <Student> students) {
        this.students = students;
    }

    public List<Student> getStudents() {
        return students;
    }

    public Student getStudentById(Long id) {
        return students.stream().filter(student -> student.getId().equals(id)).findFirst().orElse(null);
    }

    public List<Student> getAllStudentByGroupName(String groupName) {
        ArrayList<Student> result = new ArrayList<>();
        for (Student student : students) {
            if (student.getGroupName().equals(groupName)) {
                result.add(student);
            }
        }
        return result;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

}
