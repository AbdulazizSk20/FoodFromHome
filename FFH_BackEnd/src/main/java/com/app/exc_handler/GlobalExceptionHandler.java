package com.app.exc_handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.app.custom_exceptions.CustomerHandlingException;
import com.app.custom_exceptions.ResourceNotFoundException;
import com.app.custom_exceptions.UserHandlingException;
import com.app.dto.ErrorResponse;

@ControllerAdvice // MANDATORY annotation to tell SC , following is the global exc handler class
// to intercept exceptions in all controllers n rest controllers
//ResponseEntityExceptionHandler => a base class , for handling methdo arg not valid type of excs
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
	
//	@Override
//	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
//			HttpHeaders headers, HttpStatus status, WebRequest request) {
//		// what is expected ret type ? RespEntity -- status : 400 , Body : map of field
//		// name n err mesg
//		System.out.println("in global handler : method arg invalid");
////		Map<String , String> errorMap=new HashMap<>();
////		for(FieldError e : ex.getFieldErrors())
////			errorMap.put(e.getField(), e.getDefaultMessage());
//		Map<String, String> errorMap = ex.getFieldErrors().stream() // Stream<FieldError>
//				.collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage));
//		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMap);
//	}
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoundException e)
	{
		System.out.println("handle res not found.... ");
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse(e.getMessage()));
	}

	@ExceptionHandler(CustomerHandlingException.class)
	public ResponseEntity<?> handleCustomerHandlingException(CustomerHandlingException e) {

		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ErrorResponse("Error: "+e.getMessage()));
	}

	@ExceptionHandler(UserHandlingException.class)
	public ResponseEntity<?> handleHomeMakerHandlingException(UserHandlingException e) {

		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(new ErrorResponse(e.getMessage()));
	}

}
