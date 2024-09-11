package dev.davletshin.CalculateVacationSalary.web.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;


@Data
@NoArgsConstructor
public class VacationRequest {
    @Schema(description = "average salary")
    @NotNull(message = "Average Salary must be not null")
    @Min(5000)
    protected BigDecimal averageSalary;
}
