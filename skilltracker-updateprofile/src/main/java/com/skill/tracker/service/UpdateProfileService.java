package com.skill.tracker.service;

import com.skill.tracker.model.SkillSet;

public interface UpdateProfileService {

	public String updateProfile(String associateId, SkillSet skillSetRqst) throws Exception;
}
