package com.cg.smartdeploy.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomExceptionController {
//	 @ExceptionHandler(value = { IOException.class })
//	    @ResponseStatus(HttpStatus.BAD_REQUEST)
//	    public ErrorMessageStructure badRequest(Exception ex)
//	    {
//	        return new ErrorMessageStructure(400, ErrorMessages.MESSAGE17);
//	    }
//	    
//	    @ExceptionHandler(value = { Exception.class })
//	    @ResponseStatus(HttpStatus.NOT_FOUND)
//	    public ErrorMessageStructure unKnownException(Exception ex)
//	    {
//	        return new ErrorMessageStructure(404, ErrorMessages.MESSAGE15);
//	    }
	    @ExceptionHandler(value = { ProgramException.class })
	    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	    public ErrorMessageStructure KnownException(Exception ex)
	    {
	        return new ErrorMessageStructure(500, ErrorMessages.MESSAGE17);
	    }
	

}
