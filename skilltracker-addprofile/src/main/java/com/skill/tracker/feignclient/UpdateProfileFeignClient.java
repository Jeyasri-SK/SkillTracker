package com.skill.tracker.feignclient;

import javax.validation.Valid;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.skill.tracker.model.SkillSet;

@FeignClient(value="FeignUpdateProfileService", url="http://localhost:3002")
public interface UpdateProfileFeignClient {
	
	@PostMapping(value = "/skill-tracker/api/v1/update-profile/{associateId}")
	String updateProfile(@PathVariable String associateId, @RequestBody @Valid SkillSet skillSetRqst);
}
