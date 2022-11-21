package com.paradoxcalculator.europa.exceptions;

import com.paradoxcalculator.europa.exceptions.CustomException;
import com.paradoxcalculator.europa.pojo.APIResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalErrorHandler {
    @ExceptionHandler(CustomException.class)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public APIResponse<?> handleCustomException(CustomException ex)
    {
        return new APIResponse<>("", ex.getMessage(), ex.getCode());
    }
}
