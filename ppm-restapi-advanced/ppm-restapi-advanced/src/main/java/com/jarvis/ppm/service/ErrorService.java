package com.jarvis.ppm.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

@Service
public class ErrorService {

	public ResponseEntity<?> errorValidation(BindingResult result) {
		if (result.hasErrors()) {
			Map<String, String> errors = new HashMap<String, String>();
			for (FieldError error : result.getFieldErrors()) {
				errors.put(error.getField(), error.getDefaultMessage());
			}
			return new ResponseEntity<Map<String, String>>(errors, HttpStatus.BAD_REQUEST);
		}
		return null;
	}
}