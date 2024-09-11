package dev.davletshin.CalculateVacationSalary.web.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
public class VacationResponse {
    @NotNull
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    protected BigDecimal averageSalary;

    @NotNull
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    protected BigDecimal vacationSalary;
}
