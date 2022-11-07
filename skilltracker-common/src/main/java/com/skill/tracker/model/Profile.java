package com.skill.tracker.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.validation.Valid;

public class Profile implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long requestId;
	private String name;
	private String associateId;
	private Long mobile;
	private String email;
	@Valid
	private SkillSet skillSets;
	private LocalDateTime createdDateTime;
	private LocalDateTime updatedDateTime;
	
	public Long getRequestId() {
		return requestId;
	}
	public void setRequestId(Long requestId) {
		this.requestId = requestId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAssociateId() {
		return associateId;
	}
	public void setAssociateId(String associateId) {
		this.associateId = associateId;
	}
	public Long getMobile() {
		return mobile;
	}
	public void setMobile(Long mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public SkillSet getSkillSets() {
		return skillSets;
	}
	public void setSkillSets(SkillSet skillSets) {
		this.skillSets = skillSets;
	}
	public LocalDateTime getCreatedDateTime() {
		return createdDateTime;
	}
	public void setCreatedDateTime(LocalDateTime createdDateTime) {
		this.createdDateTime = createdDateTime;
	}
	public LocalDateTime getUpdatedDateTime() {
		return updatedDateTime;
	}
	public void setUpdatedDateTime(LocalDateTime updatedDateTime) {
		this.updatedDateTime = updatedDateTime;
	}
}