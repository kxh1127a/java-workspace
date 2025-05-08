package com.example.codingtest.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QuestionCreateRequest {
    private Long SubjectId;
    private String content;
}
