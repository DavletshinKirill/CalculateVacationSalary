package dev.davletshin.CalculateVacationSalary.web.controller;

import dev.davletshin.CalculateVacationSalary.service.CalculateSalaryService;
import dev.davletshin.CalculateVacationSalary.web.dto.request.VacationRequestDTO;
import dev.davletshin.CalculateVacationSalary.web.dto.request.VacationRequestDateDTO;
import dev.davletshin.CalculateVacationSalary.web.dto.response.VacationResponseDTO;
import dev.davletshin.CalculateVacationSalary.web.dto.response.VacationResponseDateDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigDecimal;


@RestController
@RequestMapping("/api/v1/calculate")
@RequiredArgsConstructor
@Tag(name = "Calculate Salary Controller", description = "Calculate Salary API")
public class CalculateSalaryController {

    private final CalculateSalaryService calculateSalaryService;


    @Operation(summary = "calculate salary")
    @GetMapping()
    public VacationResponseDTO calculateSalary(@Validated VacationRequestDTO vacationDTO) {

        BigDecimal vacationSalary = calculateSalaryService
                .calculateSalary(vacationDTO.getAverageSalary(), vacationDTO.getVacationDays());

        return new VacationResponseDTO(vacationDTO.getAverageSalary(), vacationSalary,
                vacationDTO.getVacationDays());
    }

    @Operation(summary = "calculate salary with dates")
    @PostMapping("/dates")
    public VacationResponseDateDTO calculateSalaryWithDates(
            @Valid @RequestBody VacationRequestDateDTO vacationRequestDTO) {
        int vacationDays = vacationRequestDTO.amountOfWorkingDays();

        BigDecimal vacationSalary = calculateSalaryService
                .calculateSalary(vacationRequestDTO.getAverageSalary(), vacationDays);

        return new VacationResponseDateDTO(vacationRequestDTO.getStartVacation(),
                vacationRequestDTO.getEndVacation(),
                vacationRequestDTO.getAverageSalary(), vacationSalary);
    }
}
