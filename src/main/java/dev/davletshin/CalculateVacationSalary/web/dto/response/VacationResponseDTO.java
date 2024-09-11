package dev.davletshin.CalculateVacationSalary.web.dto.response;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Data
public class VacationResponseDTO extends VacationResponse {


    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private int vacationDays;

    public VacationResponseDTO(
            @NotNull(message = "Average Salary must be not null") @Min(5000) BigDecimal averageSalary,
            BigDecimal vacationSalary, int vacationDays) {
        this.averageSalary = averageSalary;
        this.vacationSalary = vacationSalary;
        this.vacationDays = vacationDays;
    }
}
