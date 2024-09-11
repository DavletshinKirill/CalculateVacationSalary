package dev.davletshin.CalculateVacationSalary.web.dto.response;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@RequiredArgsConstructor
@Data
public class VacationResponseDateDTO extends VacationResponse {
    @NotNull
    private LocalDateTime startVacation;
    @NotNull
    private LocalDateTime endVacation;

    public VacationResponseDateDTO(
            @NotNull LocalDateTime startVacation,
            @NotNull LocalDateTime endVacation,
            @NotNull(message = "Average Salary must be not null") @Min(5000) BigDecimal averageSalary,
            BigDecimal vacationSalary) {
        super(averageSalary, vacationSalary);
        this.startVacation = startVacation;
        this.endVacation = endVacation;
    }
}
