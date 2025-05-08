package com.example.codingtest.service;

import com.example.codingtest.entity.Question;
import com.example.codingtest.entity.Score;
import com.example.codingtest.entity.Student;
import com.example.codingtest.repository.ScoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ScoreService {
    private final ScoreRepository scoreRepository;

    public void setScore(Student student, Question question, Long grade) {
        Optional<Score> score = scoreRepository.findAllByStudentAndQuestion(student, question);
        if(score.isEmpty()) {
            Score addItem = new Score();
            addItem.setStudent(student);
            addItem.setQuestion(question);
            addItem.setGrade(grade);
            scoreRepository.save(addItem);
        }
    }
}
