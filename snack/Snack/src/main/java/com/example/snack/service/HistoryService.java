package com.example.snack.service;

import com.example.snack.entity.History;
import com.example.snack.entity.Snack;
import com.example.snack.exception.CMissingDataException;
import com.example.snack.model.HistoryCreateRequest;
import com.example.snack.repository.HistoryRepository;
import com.example.snack.repository.SnackRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HistoryService {
    private final HistoryRepository historyRepository;
    private final SnackRepository snackRepository;


    public void setHistory(HistoryCreateRequest request, long id) {
        Snack target = snackRepository.findById(id).orElseThrow(CMissingDataException::new);
        History history = new History.Builder(target, request).build();
        historyRepository.save(history);
    }
}
