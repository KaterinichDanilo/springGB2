package com.springGB.springGB.Lesson3.services;

import com.springGB.springGB.Lesson3.repositories.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public StudentRepository getStudentRepository() {
        return studentRepository;
    }
}
