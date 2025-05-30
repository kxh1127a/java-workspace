package com.example.baseframe.service;

import com.example.baseframe.entity.TestStock;
import com.example.baseframe.exception.CMissingDataException;
import com.example.baseframe.exception.CWrongIdException;
import com.example.baseframe.repository.TestStockRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TestStockService {
    private final TestStockRepository testStockRepository;

    public TestStock getStock(long id) {
        return testStockRepository.findById(id).orElseThrow(CMissingDataException::new);
    }

    public List<TestStock> getStocks() {
        return testStockRepository.findAll();
    }

    public void putTestStockByCount(String name, int eatCount) {
        TestStock testStock = testStockRepository.findFirstByNameAndIsSoldOutOrderByDateIn(name, false).orElseThrow(CMissingDataException::new);

        if (testStock.getCount() < eatCount) throw new CWrongIdException();

        testStock.setCount(testStock.getCount() - eatCount);

        if (testStock.getCount() == 0) {
            testStock.setIsSoldOut(true);
            testStock.setDateSoldOut(LocalDate.now());
        }

        testStockRepository.save(testStock);
    }
}
