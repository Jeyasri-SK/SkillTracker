package com.skill.tracker.mongo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.skill.tracker.mongo.collections.AssociateProfileDetails;

public interface AssociateProfileRepository extends MongoRepository<AssociateProfileDetails, String> {	
	
	@Query("{associateId:'?0'}")
	List<AssociateProfileDetails> findAllByAssociateId(String associateId);
	
	@Query("{name:'?0'}")
	List<AssociateProfileDetails> findAllByName(String name);
	
	@Query("{email:'?0'}")
	List<AssociateProfileDetails> findAllByEmail(String email);
	
}