package com.skill.tracker.mongodb.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.skill.tracker.mongodb.collections.AssociateProfileDetails;

public interface AssociateProfileRepository extends MongoRepository<AssociateProfileDetails, String> {	
	
	@Query("{associateId:'?0'}")
	Optional<AssociateProfileDetails> findById(String associateId);
	
	@Query("{name:'?0'}")
	AssociateProfileDetails findByName(String name);
}