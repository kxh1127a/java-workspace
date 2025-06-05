package com.example.snack.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HistoryCreateRequest {
    private String name;
    private Integer amount;
}
