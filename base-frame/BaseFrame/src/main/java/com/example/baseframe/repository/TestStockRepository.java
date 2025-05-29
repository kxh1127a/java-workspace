package com.example.baseframe.repository;

import com.example.baseframe.entity.TestStock;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Optional;

public interface TestStockRepository extends JpaRepository<TestStock, Long> {

    // select * from test_stock where name = ?1 and is_sold_out = ?2 order by date_in
    Optional<TestStock> findFirstByNameAndIsSoldOutOrderByDateIn(String name, boolean isSoldOut);
}

