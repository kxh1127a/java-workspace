package com.example.codingtest.service;

import com.example.codingtest.entity.Subject;
import com.example.codingtest.model.SubjectCreateRequest;
import com.example.codingtest.repository.SubjectRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SubjectService {
    private final SubjectRepository subjectRepository;

    public void setSubject(SubjectCreateRequest request) {
        Subject subject = new Subject();
        subject.setLanguage(request.getLanguage());
        subjectRepository.save(subject);
    }


    public Subject getSubject(Long subjectId) {
        return subjectRepository.findById(subjectId).orElseThrow();
    }
}
