package com.skill.tracker.mongodb.collections;

import java.time.LocalDateTime;
import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "associateprofiledetails")
public class AssociateProfileDetails {

	@Id
	private Long requestId;
	private String name;
	@Indexed(unique = true)
	private String associateId;
	@Indexed(unique = true)
	private Long mobile;
	@Indexed(unique = true)
	private String email;	
	private Map<String, Object> skillSets;
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
	public Map<String, Object> getSkillSets() {
		return skillSets;
	}
	public void setSkillSets(Map<String, Object> skillSets) {
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