package com.dsproject.client.resources.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.dsproject.client.services.exceptions.ResourceNotFounException;
import com.dsproject.client.services.exceptions.dataBaseException;

@ControllerAdvice
public class ResourceExceptionHandler {
	
	@ExceptionHandler(ResourceNotFounException.class)
	public ResponseEntity<StandardError> entityNotFound (ResourceNotFounException e, HttpServletRequest request){
		
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError err = new StandardError();
		err.setTimestamp(Instant.now());
		err.setStatus(status.value());
		err.setError("Resource not found");
		err.setMassage(e.getMessage());
		err.setPaht(request.getRequestURI());
		
		return ResponseEntity.status(status).body(err);
	}
	
	@ExceptionHandler(dataBaseException.class)
	public ResponseEntity<StandardError> dataBase (dataBaseException e, HttpServletRequest request){
		HttpStatus status = HttpStatus.BAD_REQUEST;
		StandardError err = new StandardError();
		err.setTimestamp(Instant.now());
		err.setStatus(status.value());
		err.setError("Database exception");
		err.setMassage(e.getMessage());
		err.setPaht(request.getRequestURI());
		
		return ResponseEntity.status(status).body(err);
	}

}
