package com.example.codingtest.service;

import com.example.codingtest.entity.Question;
import com.example.codingtest.entity.Subject;
import com.example.codingtest.model.QuestionCreateRequest;
import com.example.codingtest.model.QuestionItem;
import com.example.codingtest.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class QuestionService {
    private final QuestionRepository questionRepository;


    public void setQuestion(Subject subject, String content) {
        Question question = new Question();
        question.setSubject(subject);
        question.setContent(content);
        questionRepository.save(question);
    }

    public Question getQuestion(Long questionId) {
        return questionRepository.findById(questionId).orElseThrow();
    }


    public List<QuestionItem> getQuestions(Subject subject) {
        List<Question> target = questionRepository.findBySubject(subject);
        List<QuestionItem> result = new LinkedList<>();

        target.forEach(item-> {
            QuestionItem addItem = new QuestionItem();
            addItem.setQuestionNo(item.getId());
            addItem.setQuestionInfo(item.getSubject().getLanguage()+" 문제: " +item.getContent());
            result.add(addItem);
        });

        return result;
    }
}
