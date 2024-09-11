package dev.davletshin.CalculateVacationSalary.web.controller;

import dev.davletshin.CalculateVacationSalary.exception.ExceptionBody;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class AdviceController {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ExceptionBody notValid(MethodArgumentNotValidException ex, HttpServletRequest request) {
        return new ExceptionBody("Vacation start date must be after end date date");
    }
}
