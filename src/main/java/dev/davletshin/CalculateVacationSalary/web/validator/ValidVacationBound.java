package dev.davletshin.CalculateVacationSalary.web.validator;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Constraint(validatedBy = VacationBoundValidator.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidVacationBound {
    String startDate();

    String endDate();

    String message() default "Start vacation must be before end vacation";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
