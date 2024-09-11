package dev.davletshin.CalculateVacationSalary.web.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import dev.davletshin.CalculateVacationSalary.web.validator.ValidVacationBound;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.time.DayOfWeek;
import java.time.LocalDateTime;


@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@ValidVacationBound(startDate = "startVacation", endDate = "endVacation")
public class VacationRequestDateDTO extends VacationRequest {

    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    private LocalDateTime startVacation;

    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    private LocalDateTime endVacation;

    public int amountOfWorkingDays() {


        int workingDaysCount = 0;

        for (LocalDateTime date = startVacation; !date.isAfter(endVacation); date = date.plusDays(1)) {
            DayOfWeek dayOfWeek = date.getDayOfWeek();
            if (dayOfWeek != DayOfWeek.SATURDAY && dayOfWeek != DayOfWeek.SUNDAY) {
                workingDaysCount++;
            }
        }

        return workingDaysCount;
    }


}
