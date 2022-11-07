package com.skill.tracker.controller;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.skill.tracker.constants.SkillTrackerConstants;
import com.skill.tracker.model.SkillSet;
import com.skill.tracker.service.UpdateProfileService;

@RestController
public class UpdateProfileController {
	
	private static final Logger LOGGER = LogManager.getLogger(UpdateProfileController.class);

	@Autowired
	UpdateProfileService updateProfileService;
	
	@PostMapping(value="/skill-tracker/api/v1/update-profile/{associateId}")
	public ResponseEntity<String> updateProfile(@PathVariable String associateId, @RequestBody @Valid SkillSet skillSetRqst) throws Exception{
		LOGGER.info("Begin UpdateProfileController - updateProfile() ");
		String response = "";
		try {
			response = updateProfileService.updateProfile(associateId, skillSetRqst);
		}catch(Exception e) {
			LOGGER.error("Exception while updating profile: "+ e);
			return new ResponseEntity<String>("Profile update failed: "+ e.getLocalizedMessage(), HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<String>(SkillTrackerConstants.SUCCESS + response, HttpStatus.OK);
	}
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleMethodArgumentNotValid(MethodArgumentNotValidException ex){
		Map<String, String> errors = new HashMap<>();
		ex.getBindingResult().getFieldErrors().forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));		
		return errors;
	}
}
