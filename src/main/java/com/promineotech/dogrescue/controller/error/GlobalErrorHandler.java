package com.promineotech.dogrescue.controller.error;

import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalErrorHandler {

//	@ExceptionHandler(DuplicateKeyException.class)
//	public ResponseEntity<String> handleError(DuplicateKeyException dupKeyError) {
//		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(dupKeyError.getMessage());
//	}
//
//	@ExceptionHandler(Exception.class)
//	public ResponseEntity<String> handleError(Exception ex) {
//		ex.printStackTrace();
//		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
//	}

//	@ExceptionHandler(NoSuchElementException.class)
//	public ResponseEntity<String> handleError(NoSuchElementException ex) {
//		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
//	}
}
