package dev.davletshin.CalculateVacationSalary;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(info = @Info(title = "API", version = "v1"))
@SpringBootApplication
public class CalculateVacationSalaryApplication {

    public static void main(String[] args) {
        SpringApplication.run(CalculateVacationSalaryApplication.class, args);
    }

}
