package dev.davletshin.CalculateVacationSalary.service;


import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.math.RoundingMode;

@SpringBootTest
public class CalculateSalaryServiceImplTest {

    private final CalculateSalaryServiceImpl calculateSalaryService = new CalculateSalaryServiceImpl();

    @Test
    public void testCalculateSalary() {

        BigDecimal inputSalary = new BigDecimal(50000);
        int inputVacationDays = 7;

        BigDecimal expectedSalary = inputSalary
                .divide(new BigDecimal(29.3), 10, RoundingMode.HALF_UP)
                .multiply(new BigDecimal(inputVacationDays)).setScale(2, RoundingMode.HALF_UP);

        BigDecimal result = calculateSalaryService.calculateSalary(inputSalary, inputVacationDays);

        Assertions.assertEquals(expectedSalary, result);
    }
}
