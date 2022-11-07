package com.skill.tracker;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SkillTrackerSearchApplication {
	
	private static final Logger LOGGER = LogManager.getLogger(SkillTrackerSearchApplication.class);
	
	public static void main(String args[]) {
		try {
			LOGGER.info("Begin SkillTrackerSearchApplication - args: "+ args);
			SpringApplication.run(SkillTrackerSearchApplication.class, args);
		} catch(Exception e) {
			LOGGER.error("Exception in SkillTrackerSearchApplication: "+ e);
		}		
	}
}