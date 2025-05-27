package com.example.giftlog.repository;

import com.example.giftlog.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person, Long> {
    Optional<Person> findByPhoneAndName(String phone, String name);
}
