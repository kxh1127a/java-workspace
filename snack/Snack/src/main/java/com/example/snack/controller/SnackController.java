package com.example.snack.controller;

import com.example.snack.model.SnackCreateRequest;
import com.example.snack.model.SnackItem;
import com.example.snack.model.SnackReadRequest;
import com.example.snack.model.SnackResponse;
import com.example.snack.model.result.ListResult;
import com.example.snack.model.result.SingleResult;
import com.example.snack.service.ResponseService;
import com.example.snack.service.SnackService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import static com.example.snack.service.ResponseService.getListResult;

@RestController
@RequiredArgsConstructor
@RequestMapping("/snack")
public class SnackController {
    private final SnackService snackService;

    @PostMapping("/new")
    public SingleResult<SnackResponse> setSnack(@RequestBody @Valid SnackCreateRequest request) {
        return ResponseService.getSingleResult(snackService.setSnack(request));
    }

    @GetMapping("/all")
    public ListResult<SnackItem> getSnacks() {
        return ResponseService.getListResult(snackService.getSnacks());
    }

    @GetMapping("/details")
    public SingleResult<SnackResponse> getSnack(@RequestBody @Valid SnackReadRequest request) {
        return ResponseService.getSingleResult(snackService.getSnack(request));
    }
}
