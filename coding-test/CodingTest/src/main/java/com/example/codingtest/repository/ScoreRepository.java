package com.example.codingtest.repository;

import com.example.codingtest.entity.Question;
import com.example.codingtest.entity.Score;
import com.example.codingtest.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ScoreRepository extends JpaRepository<Score, Long> {
    Optional<Score> findAllByStudentAndQuestion (Student student, Question question);
    List<Score> findAllByStudent_id(Long studentId);
    Score findAllByStudent_idAndQuestion_id(Long studentId, Long QuestionId);
    List<Score> findAllByQuestion_idAndIsViewTrue(Long questionId);
}
