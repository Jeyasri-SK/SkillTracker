package com.skill.tracker.service;

import java.util.List;

import com.skill.tracker.model.Profile;

public interface SearchProfileService {
	
	public List<Profile> searchProfile(String criteria, String criteriaValue) throws Exception;
}