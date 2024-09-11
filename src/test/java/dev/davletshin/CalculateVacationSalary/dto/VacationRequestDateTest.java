package dev.davletshin.CalculateVacationSalary.dto;

import dev.davletshin.CalculateVacationSalary.web.dto.request.VacationRequestDateDTO;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class VacationRequestDateTest {

    @Test
    public void testAmountOfWorkingDays() {
        VacationRequestDateDTO vacationRequestDateDTO = new VacationRequestDateDTO();

        LocalDateTime startVacation = LocalDateTime.of(2023, 10, 2, 0, 0); // Monday
        LocalDateTime endVacation = LocalDateTime.of(2023, 10, 6, 0, 0);   // Friday
        vacationRequestDateDTO.setStartVacation(startVacation);
        vacationRequestDateDTO.setEndVacation(endVacation);

        assertEquals(5, vacationRequestDateDTO.amountOfWorkingDays());


        startVacation = LocalDateTime.of(2023, 10, 7, 0, 0); // Saturday
        endVacation = LocalDateTime.of(2023, 10, 8, 0, 0);   // Sunday
        vacationRequestDateDTO.setStartVacation(startVacation);
        vacationRequestDateDTO.setEndVacation(endVacation);

        assertEquals(0, vacationRequestDateDTO.amountOfWorkingDays());
    }

}
