package com.example.giftlog.controller;

import com.example.giftlog.model.GiftCreateRequest;
import com.example.giftlog.model.GiftItem;
import com.example.giftlog.model.PersonCreateRequest;
import com.example.giftlog.model.PersonItem;
import com.example.giftlog.service.GiftService;
import com.example.giftlog.service.LogService;
import com.example.giftlog.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ApiController {
    private final GiftService giftService;
    private final LogService logService;
    private final PersonService personService;

    @PostMapping("/gift/new")
    public String setGift(@RequestBody GiftCreateRequest request) {
        giftService.setGift(request);
        return "CREATE NEW GIFT LIST!";
    }

    @PostMapping("/person/new")
    public String setPerson(@RequestBody PersonCreateRequest request) {
        personService.setPerson(request);
        return "CREATE NEW PERSON LIST!";
    }

    @GetMapping("/gift")
    public List<GiftItem> getGifts() {
        return giftService.getGifts();
    }

    @GetMapping("/person")
    public List<PersonItem> getPersons() {
        return personService.getPersons();
    }

}
