package com.skill.tracker;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SkillTrackerUpdateApplication {
	
	private static final Logger LOGGER = LogManager.getLogger(SkillTrackerUpdateApplication.class);
	
	public static void main(String args[]) {
		try {
			LOGGER.info("Begin SkillTrackerUpdateApplication - args: "+ args);
			 SpringApplication.run(SkillTrackerUpdateApplication.class, args);
		} catch(Exception e) {
			LOGGER.error("Exception in SkillTrackerUpdateApplication: "+ e);
		}		
	}
}