package dev.davletshin.CalculateVacationSalary.service;

import java.math.BigDecimal;

public interface CalculateSalaryService {

    BigDecimal calculateSalary(BigDecimal salary, int vacationDays);
}
