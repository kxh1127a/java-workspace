package com.example.codingtest.repository;

import com.example.codingtest.entity.Question;
import com.example.codingtest.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Long> {
    List<Question> findBySubject(Subject subject);
}
