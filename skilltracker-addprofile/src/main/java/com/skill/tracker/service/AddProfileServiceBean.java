package com.skill.tracker.service;

import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.skill.tracker.model.Profile;
import com.skill.tracker.mongo.collections.AssociateProfileDetails;
import com.skill.tracker.mongo.repository.AssociateProfileRepository;
import com.skill.tracker.monogdb.connection.DbConnectionConfig;

@Service
public class AddProfileServiceBean implements AddProfileService{
	
	private static final Logger LOGGER = LogManager.getLogger(AddProfileServiceBean.class);
	 
	@Autowired
	AssociateProfileRepository associateProfileRepository;
	
	@Autowired 
	DbConnectionConfig dbConnectionConfig;
	
	public Long addProfile(Profile profile) throws Exception {		
		LOGGER.info("Begin AddProfileServiceBean addProfile() - Name:" + profile.getName());
		
		if (profile != null) {
			if (profile.getName() == null && !(profile.getName().length() <= 5) && !(profile.getName().length() >= 30)) {
				throw new Exception("Name should be not null with minimum of 5 and maximum of 30 characters");
			}
			if (profile.getAssociateId() == null || !(profile.getAssociateId().toString().length() >= 5 && profile.getAssociateId().toString().length() <= 30)) {
				throw new Exception("Associate Id should be not null, start with \"CTS\" and with minimum of 5 and maximum of 30 characters");
			}
			if (profile.getMobile() == null && profile.getMobile().toString().length() < 10) {
				throw new Exception("Mobile number should be not null and 10 digit");
			}

			String regex = "^(.+)@(.+)$";
			Pattern pattern = Pattern.compile(regex);
			Matcher matcher = pattern.matcher(profile.getEmail());
			if (profile.getEmail() == null || !matcher.matches()) {
				throw new Exception("Email should be not null and have valid email pattern with one \"@\"");
			}
		}
		AssociateProfileDetails associateProfileDetails = new AssociateProfileDetails();
		try {
			//dbConnectionConfig.getMonogDbConnection();
			associateProfileDetails.setRequestId(UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE);
			associateProfileDetails.setName(profile.getName());
			associateProfileDetails.setAssociateId(profile.getAssociateId());
			associateProfileDetails.setMobile(profile.getMobile());
			associateProfileDetails.setEmail(profile.getEmail());
			associateProfileDetails.setSkillSets(setAssociateSkillSets(profile));
			associateProfileDetails.setCreatedDateTime(LocalDateTime.now());
			associateProfileDetails.setUpdatedDateTime(LocalDateTime.now());
			
			associateProfileDetails = associateProfileRepository.insert(associateProfileDetails);			
		} catch(Exception e) {
			LOGGER.error(e.getLocalizedMessage());			
			throw new Exception(e.getMessage());
		}					
		return associateProfileDetails.getRequestId();
	}
	
	@SuppressWarnings("unchecked")
	public Map<String, Object> setAssociateSkillSets(Profile profile){
		ObjectMapper oMapper = new ObjectMapper();
		Map<String, Integer> skillSetValueMap = oMapper.convertValue(profile.getSkillSets(), Map.class);		
		Map<String, Object> skillSetsMap = new HashMap<>();
		
		Class<?> clazz = profile.getSkillSets().getClass();	
		for (Field field : clazz.getDeclaredFields()) {
			if(field.getName() != null && !field.getName().equals("serialVersionUID")) {
				skillSetsMap.put(field.getName(), skillSetValueMap.get(field.getName()));				
			}
		}
		return skillSetsMap;
	}
	
	/*@SuppressWarnings("unchecked")
	public List<AssociateSkillSetDetails> setAssociateSkillSet(Long requestId, Profile profile, Map<String, Object> skillSetsMap) {
		ObjectMapper oMapper = new ObjectMapper();
		Map<String, Integer> skillSetMap = oMapper.convertValue(profile.getSkillSets(), Map.class);
		List<AssociateSkillSetDetails> associateSkillSetDetailsList = new ArrayList<>();		
		
		Class<?> clazz = profile.getSkillSets().getClass();	
		for (Field field : clazz.getDeclaredFields()) {			
			AssociateSkillSetDetails associateSkillSetDetails = new AssociateSkillSetDetails();
			if(field.getName() != null && !field.getName().equals("serialVersionUID")) {
				associateSkillSetDetails.setId(UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE);
				//associateSkillSetDetails.setRequestId(requestId);
				associateSkillSetDetails.setAssociateId(requestId);			
				associateSkillSetDetails.setSkillsetId(SkillSetEnum.getSkillSetId(field.getName()).getSkillSetId());
				associateSkillSetDetails.setProficinecyLevel(skillSetMap.get(field.getName()));
				associateSkillSetDetails.setCreatedDateTime(LocalDateTime.now());
				associateSkillSetDetails.setUpdatedDateTime(LocalDateTime.now());
				
				associateSkillSetDetailsList.add(associateSkillSetDetails);
			}
		}
		return associateSkillSetDetailsList;
	}*/
}