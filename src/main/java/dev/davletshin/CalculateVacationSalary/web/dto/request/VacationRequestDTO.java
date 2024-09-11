package dev.davletshin.CalculateVacationSalary.web.dto.request;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;


@EqualsAndHashCode(callSuper = true)
@Data
@Schema(description = "Request for vacation request")
@AllArgsConstructor
@NoArgsConstructor
public class VacationRequestDTO extends VacationRequest {

    @Schema(description = "vacation days", example = "14")
    @NotNull(message = "Vacation Days must be not null")
    @Min(7)
    private int vacationDays;

}
