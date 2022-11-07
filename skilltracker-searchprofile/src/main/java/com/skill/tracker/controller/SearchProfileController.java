package com.skill.tracker.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.skill.tracker.model.Profile;
import com.skill.tracker.service.SearchProfileService;

@RestController
public class SearchProfileController {

	private static final Logger LOGGER = LogManager.getLogger(SearchProfileController.class);
	
	@Autowired
	SearchProfileService searchProfileService;
	
	@PostMapping(value="/skill-tracker/api/v1/admin/{criteria}/{criteriaValue}")
	public ResponseEntity<?> searchProfile(@PathVariable String criteria, @PathVariable String criteriaValue) throws Exception{
		LOGGER.info("Begin SearchProfileController - searchProfile() ");
		List<Profile> profileList = new ArrayList<>();
		try {
			profileList = searchProfileService.searchProfile(criteria, criteriaValue);
		}catch(Exception e) {
			LOGGER.error("Exception while searching profile: "+ e);			
			return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
		return new ResponseEntity<List<Profile>>(profileList, HttpStatus.OK);
	}
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleMethodArgumentNotValid(MethodArgumentNotValidException ex){
		Map<String, String> errors = new HashMap<>();
		ex.getBindingResult().getFieldErrors().forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));		
		return errors;
	}
}
