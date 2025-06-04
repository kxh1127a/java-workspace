package com.example.snack.repository;

import com.example.snack.entity.Snack;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SnackRepository extends JpaRepository<Snack, Long> {
    Optional<Snack> findByName(String name);
}
