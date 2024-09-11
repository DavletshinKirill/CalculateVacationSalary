package dev.davletshin.CalculateVacationSalary.web.validator;

import dev.davletshin.CalculateVacationSalary.web.dto.request.VacationRequestDateDTO;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDateTime;

public class VacationBoundValidator implements ConstraintValidator<ValidVacationBound, VacationRequestDateDTO> {


    private String startDate;
    private String endDate;

    @Override
    public void initialize(ValidVacationBound matching) {
        this.startDate = matching.startDate();
        this.endDate = matching.endDate();
    }

    @Override
    public boolean isValid(VacationRequestDateDTO value, ConstraintValidatorContext context) {
        LocalDateTime startVacation = LocalDateTime.parse(value.getStartVacation().toString());
        LocalDateTime endVacation = LocalDateTime.parse(value.getEndVacation().toString());

        return startVacation.isBefore(endVacation);
    }
}

