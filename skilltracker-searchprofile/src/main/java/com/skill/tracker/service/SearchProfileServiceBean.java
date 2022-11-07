package com.skill.tracker.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.skill.tracker.model.Profile;
import com.skill.tracker.model.SkillSet;
import com.skill.tracker.mongo.collections.AssociateProfileDetails;
import com.skill.tracker.mongo.repository.AssociateProfileRepository;
import com.skill.tracker.monogdb.connection.DbConnectionConfig;

@Service
public class SearchProfileServiceBean implements SearchProfileService{
	
	private static final Logger LOGGER = LogManager.getLogger(SearchProfileServiceBean.class);
	 
	@Autowired
	AssociateProfileRepository associateProfileRepository;
	
	@Autowired 
	DbConnectionConfig dbConnectionConfig;
	
	public List<Profile> searchProfile(String criteria, String criteriaValue) throws Exception {		
		LOGGER.info("Begin SearchProfileServiceBean searchProfile() - Criteria:" + criteria + " Criteria Value: "+ criteriaValue);
		List<Profile> profileList = new ArrayList<>();
		Profile profile = new Profile();
		List<AssociateProfileDetails> associateProfileDetailsList = new ArrayList<>();
		try {
			if(criteria != null && !criteria.isEmpty() && !criteria.isBlank()) {
				if(criteria.equals("name"))
					associateProfileDetailsList = associateProfileRepository.findAllByName(criteriaValue);	
				if(criteria.equals("associateId"))
					associateProfileDetailsList = associateProfileRepository.findAllByAssociateId(criteriaValue);
				if(criteria.equals("email"))
					associateProfileDetailsList = associateProfileRepository.findAllByEmail(criteriaValue);
			}
			
			for(AssociateProfileDetails associateProfileDetails: associateProfileDetailsList) {
				if(associateProfileDetails != null){
					profile.setRequestId(associateProfileDetails.getRequestId());
					profile.setAssociateId(associateProfileDetails.getAssociateId());
					profile.setName(associateProfileDetails.getName());
					profile.setMobile(associateProfileDetails.getMobile());
					profile.setEmail(associateProfileDetails.getEmail());
					profile.setSkillSets(setAssociateSkillSet(associateProfileDetails.getSkillSets()));					
					profile.setCreatedDateTime(associateProfileDetails.getCreatedDateTime());
					profile.setUpdatedDateTime(associateProfileDetails.getUpdatedDateTime());
					profileList.add(profile);
				}	
			}			
		} catch(Exception e) {
			LOGGER.error("Exception in SearchProfileServiceBean - searchProfile()"+e.getMessage() );		
		}				
		return profileList;
	}
		
	public SkillSet setAssociateSkillSet(Map<String, Object> skillSetsMap) {
		 
        /*Map<String, Object> sortedskillSetsMap = skillSetsMap.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));*/
		
		ObjectMapper oMapper = new ObjectMapper();
		SkillSet skillSet = oMapper.convertValue(skillSetsMap, SkillSet.class);
		
		return skillSet;
	}
}