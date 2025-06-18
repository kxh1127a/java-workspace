package com.example.codingtest.controller;

import com.example.codingtest.entity.Question;
import com.example.codingtest.entity.Student;
import com.example.codingtest.entity.Subject;
import com.example.codingtest.model.*;
import com.example.codingtest.repository.SubjectRepository;
import com.example.codingtest.service.QuestionService;
import com.example.codingtest.service.ScoreService;
import com.example.codingtest.service.StudentService;
import com.example.codingtest.service.SubjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
@RequiredArgsConstructor
@RequestMapping("/test")
public class CodingTestController {
    private final SubjectService subjectService;
    private final StudentService studentService;
    private final QuestionService questionService;
    private final ScoreService scoreService;

    @PostMapping("/subject")
    public void setSubject(@RequestBody SubjectCreateRequest request) {
        subjectService.setSubject(request);
    }

    @PostMapping("/student")
    public void setStudent(@RequestBody StudentCreateRequest request) {
        studentService.setStudent(request);
    }

    @PostMapping("/question")
    public void setQuestion(@RequestBody QuestionCreateRequest request) {
        Subject subject = subjectService.getSubject(request.getSubjectId());
        questionService.setQuestion(subject, request.getContent());
    }

    @CrossOrigin(origins = "http://192.168.0.60:3000")
    @PostMapping("/score")
    public ResponseEntity<String> setScore(@RequestParam Long studentId,
                                   @RequestParam Long questionId,
                                   @RequestParam Long grade) {
        Student student = studentService.getStudent(studentId);
        Question question = questionService.getQuestion(questionId);

        scoreService.setScore(student, question, grade);

        return ResponseEntity.ok("{\"status\": \"success\"}");
    }

    @GetMapping("/subject/{id}")
    public List<QuestionItem> getQuestions(@PathVariable Long id) {
        return questionService.getQuestions(subjectService.getSubject(id));
    }

    @GetMapping("/score/{id}")
    public List<ScoreItem> getScores(@PathVariable long id) {
        return scoreService.getScores(id);
    }

    @GetMapping("/score")
    public ScoreItemByBoth getScoresByBoth(@RequestParam long questionId,
                                                 @RequestParam long studentId) {
        return scoreService.getScoresByBoth(questionId, studentId);
    }

    @GetMapping("/score/total/{id}")
    public List<ScoreItemTotal> getScoreTotal (@PathVariable long id) {
        return scoreService.getScoreTotal(id);
    }

    @GetMapping("/all")
    public List<Map<String, Object>> getTest() {
        return scoreService.getAll();
    }

    @GetMapping("/all/a1")
    public List<Map<String, Object>> getTest1() {
        return scoreService.getAll();
    }

    @GetMapping("/all/a2")
    public List<Map<String, Object>> getTest2() {
        return scoreService.getAll();
    }

    @GetMapping("/all/a3")
        public List<Map<String, Object>> getTest3() {
        return scoreService.getAll();
    }

    @GetMapping("/all/a4")
            public List<Map<String, Object>> getTest4() {
            return scoreService.getAll();
        }

}
