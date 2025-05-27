package com.example.giftlog.repository;


import com.example.giftlog.entity.Gift;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GiftRepository extends JpaRepository<Gift, Long> {
    Optional<Gift> findByName(String name);
}
