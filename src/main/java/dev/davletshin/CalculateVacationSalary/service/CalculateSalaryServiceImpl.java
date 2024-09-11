package dev.davletshin.CalculateVacationSalary.service;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;


@Service
public class CalculateSalaryServiceImpl implements CalculateSalaryService {
    @Override
    public BigDecimal calculateSalary(BigDecimal salary, int vacationDays) {

        final double AVERAGE_MONTH_DAYS = 29.3;
        return salary
                .divide(new BigDecimal(AVERAGE_MONTH_DAYS), 10, RoundingMode.HALF_UP)
                .multiply(new BigDecimal(vacationDays)).setScale(2, RoundingMode.HALF_UP);

    }

}
