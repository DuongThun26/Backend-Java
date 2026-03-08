package com.javaweb.controllerAdvice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.javaweb.customException.FieldRequiredException;
import com.javaweb.model.ErrorResponseDTO;

@ControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler{
    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<Object> handleArithmeticException(ArithmeticException ex, WebRequest request) {
    	ErrorResponseDTO errorResponseDTO = new ErrorResponseDTO();
    	errorResponseDTO.setError(ex.getMessage());
    	List<String> detail = new ArrayList<>();
    	detail.add("Xem lại phần chia, không có số nào chia được cho 0!");
    	errorResponseDTO.setDetails(detail);
        return new ResponseEntity<>(errorResponseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
    @ExceptionHandler(FieldRequiredException.class)
    public ResponseEntity<Object> handleFieldRequiredException(FieldRequiredException ex, WebRequest request) {
    	ErrorResponseDTO errorResponseDTO = new ErrorResponseDTO();
    	errorResponseDTO.setError(ex.getMessage());
    	List<String> detail = new ArrayList<>();
    	detail.add("Xem lại phần name và numberOfBasement!");
    	errorResponseDTO.setDetails(detail);
        return new ResponseEntity<>(errorResponseDTO, HttpStatus.BAD_GATEWAY);
    }
}
