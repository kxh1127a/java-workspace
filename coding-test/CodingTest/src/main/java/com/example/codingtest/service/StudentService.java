package com.example.codingtest.service;

import com.example.codingtest.entity.Student;
import com.example.codingtest.model.StudentCreateRequest;
import com.example.codingtest.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    public void setStudent(StudentCreateRequest request) {
        Student student = new Student();
        student.setName(request.getName());
        studentRepository.save(student);
    }

    public Student getStudent(Long studentId) {
        return studentRepository.findById(studentId).orElseThrow();
    }
}
