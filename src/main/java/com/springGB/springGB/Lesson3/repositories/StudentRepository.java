package com.springGB.springGB.Lesson3.repositories;

import com.springGB.springGB.Lesson3.dou.Student;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class StudentRepository {
    private List<Student> studentsList;

    @PostConstruct
    public void init() {
        studentsList = new ArrayList<>(Arrays.asList(
                new Student(1L, "Milk"),
                new Student(2L, "Apple"),
                new Student(3L, "Potato"),
                new Student(3L, "Carrot"),
                new Student(3L, "Pineapple")
        ));
    }

    public List<Student> getStudentsList() {
        return studentsList;
    }

    public Student findById(Long id) {
        return studentsList.stream().filter(student -> student.getId().equals(id)).findAny().orElse(null);
    }
}
