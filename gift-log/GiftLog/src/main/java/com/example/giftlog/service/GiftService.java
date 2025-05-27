package com.example.giftlog.service;

import com.example.giftlog.entity.Gift;
import com.example.giftlog.model.GiftCreateRequest;
import com.example.giftlog.model.GiftItem;
import com.example.giftlog.repository.GiftRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GiftService {
    private final GiftRepository giftRepository;

    public void setGift(GiftCreateRequest request) {
        if (giftRepository.findByName(request.getName()).isEmpty()) {
            Gift gift = new Gift();
            gift.setName(request.getName());
            giftRepository.save(gift);
        }
    }

    public List<GiftItem> getGifts() {
        List<Gift> target = giftRepository.findAll();
        List<GiftItem> result = new LinkedList<>();

        target.forEach(item->{
           GiftItem addItem = new GiftItem();
           addItem.setId(item.getId());
           addItem.setName(item.getName());
           result.add(addItem);
        });

        return result;
    }
}
