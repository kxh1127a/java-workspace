package com.example.snack.service;

import com.example.snack.entity.Snack;
import com.example.snack.exception.CAlreadyExistsException;
import com.example.snack.exception.CMissingDataException;
import com.example.snack.model.SnackCreateRequest;
import com.example.snack.model.SnackItem;
import com.example.snack.model.SnackReadRequest;
import com.example.snack.model.SnackResponse;
import com.example.snack.model.result.SingleResult;
import com.example.snack.repository.SnackRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SnackService {
    private final SnackRepository snackRepository;

    public boolean isDuplicateSnackName(String name) {
        Optional<Snack> snack = snackRepository.findByName(name);
        return snack.isPresent();
    }

    public SnackResponse setSnack(@Valid SnackCreateRequest request) {
        boolean exists = isDuplicateSnackName(request.getName());
        if (exists) throw new CAlreadyExistsException(request.getName() + "은(는) 이미 존재하는 간식입니다.");

        Snack snack = new Snack();
        snack.setName(request.getName());
        Snack target = snackRepository.save(snack);

        SnackResponse result = new SnackResponse();
        result.setId(target.getId());
        result.setName(target.getName());

        return result;
    }

    public List<SnackItem> getSnacks() {
        List<Snack> snack = snackRepository.findAll();
        List<SnackItem> result = new LinkedList<>();

        snack.forEach(item -> {
            SnackItem addItem = new SnackItem();
            addItem.setSnackInfo(String.format("%d번 간식은 %s입니다.", item.getId(), item.getName()));
            result.add(addItem);
        });

        return result;
    }

    public SnackResponse getSnack(@Valid SnackReadRequest request) {
        Snack snack;

        if (request.getId() != null) {
            snack = snackRepository.findById(request.getId()).orElseThrow(CMissingDataException::new);
        } else if (request.getName() != null) {
            snack = snackRepository.findByName(request.getName()).orElseThrow(CMissingDataException::new);
        } else {
            throw new CMissingDataException("조회할 ID나 이름이 필요합니다.");
        }

        SnackResponse result = new SnackResponse();
        result.setId(snack.getId());
        result.setName(snack.getName());

        return result;
    }
}
