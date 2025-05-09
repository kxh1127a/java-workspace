package com.example.codingtest.service;

import com.example.codingtest.entity.Question;
import com.example.codingtest.entity.Score;
import com.example.codingtest.entity.Student;
import com.example.codingtest.model.ScoreItem;
import com.example.codingtest.model.ScoreItemByBoth;
import com.example.codingtest.model.ScoreItemTotal;
import com.example.codingtest.repository.ScoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
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

    public List<ScoreItem> getScores(long id) {
        List<Score> target = scoreRepository.findAllByStudent_id(id);
        List<ScoreItem> result = new LinkedList<>();

        target.forEach(item->{
            ScoreItem addItem = new ScoreItem();
            addItem.setId(item.getId());
            addItem.setScoreInfo(item.getStudent().getName() + "학생의 " + item.getQuestion().getSubject().getLanguage() + "(" + item.getQuestion().getContent()+") "+ "문제 점수는 " + item.getGrade() + "점 입니다.");
            result.add(addItem);
        });

        return result;
    }

    public ScoreItemByBoth getScoresByBoth(long questionId, long studentId) {
        Score target = scoreRepository.findAllByStudent_idAndQuestion_id(studentId, questionId);
        ScoreItemByBoth result = new ScoreItemByBoth();
        result.setQuestionInfo(target.getQuestion().getSubject().getLanguage() + " " + target.getQuestion().getId()+"번 문제: " + target.getQuestion().getContent());
        result.setScoreInfo(target.getStudent().getName() + " 학생의 점수는 " + target.getGrade() + "점 입니다.");

        return result;

    }

    public List<ScoreItemTotal> getScoreTotal(long questionId) {
        List<Score> target = scoreRepository.findAllByQuestion_idAndIsViewTrue(questionId);

        List<ScoreItemTotal> result = new LinkedList<>();

        target.forEach(item->{
            ScoreItemTotal addItem = new ScoreItemTotal();
            addItem.setQuestionInfo(item.getQuestion().getSubject().getLanguage() + " " + item.getQuestion().getId()+"번 문제: " + item.getQuestion().getContent());
            addItem.setScoreInfo("ID No." + item.getStudent().getId()+" "+item.getStudent().getName() + " 학생의 점수는 " + item.getGrade() + "점 입니다.");

            result.add(addItem);
        });
        return result;
    }
}
