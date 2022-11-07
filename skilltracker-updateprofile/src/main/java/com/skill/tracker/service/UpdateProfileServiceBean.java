package com.skill.tracker.service;

import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.skill.tracker.constants.SkillTrackerConstants;
import com.skill.tracker.model.SkillSet;
import com.skill.tracker.mongodb.collections.AssociateProfileDetails;
import com.skill.tracker.mongodb.repository.AssociateProfileRepository;
import com.skill.tracker.monogdb.connection.DbConnectionConfig;

@Service
public class UpdateProfileServiceBean implements UpdateProfileService{
	
	private static final Logger LOGGER = LogManager.getLogger(UpdateProfileServiceBean.class);	
	 
	@Autowired
	AssociateProfileRepository associateProfileRepository;
	
	@Autowired 
	DbConnectionConfig dbConnectionConfig;
	
	public String updateProfile(String associateId, SkillSet skillSetRqst) throws Exception {		
		LOGGER.info("Begin UpdateProfileServiceBean updateProfile() - Associate Id:" + associateId);
		
		AssociateProfileDetails associateProfileDetails = new AssociateProfileDetails();
		try {			
			Optional<AssociateProfileDetails> profileDtlsToBeUpdated = associateProfileRepository.findById(associateId);
			
			if(!profileDtlsToBeUpdated.isEmpty()) {
				Map<String, Object> skillSetsMap = setAssociateSkillSet(skillSetRqst);
				profileDtlsToBeUpdated.get().setSkillSets(skillSetsMap);				
				profileDtlsToBeUpdated.get().setUpdatedDateTime(LocalDateTime.now());
			}else {				
				throw new Exception (SkillTrackerConstants.ASSOCIATE_ID_NOT_VALID);
			}
			
			associateProfileDetails = associateProfileRepository.save(profileDtlsToBeUpdated.get());					  
		} catch(Exception e) {
			LOGGER.error("Exception in UpdateProfileServiceBean - updateProfile()"+e.getMessage());
			throw new Exception (e.getMessage());
		}				
		return associateProfileDetails.getAssociateId();
	}
	
	@SuppressWarnings("unchecked")
	public Map<String, Object> setAssociateSkillSet(SkillSet skillSetRqst) {
		ObjectMapper oMapper = new ObjectMapper();
		Map<String, Integer> skillSetValueMap = oMapper.convertValue(skillSetRqst, Map.class);		
		Map<String, Object> skillSetsMap = new HashMap<>();
		
		Class<?> clazz = skillSetRqst.getClass();	
		for (Field field : clazz.getDeclaredFields()) {
			if(field.getName() != null && !field.getName().equals("serialVersionUID")) {
				skillSetsMap.put(field.getName(), skillSetValueMap.get(field.getName()));				
			}
		}
		return skillSetsMap;
	}
}