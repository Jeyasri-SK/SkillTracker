package com.skill.tracker;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SkillTrackerAddApplication {
	
	private static final Logger LOGGER = LogManager.getLogger(SkillTrackerAddApplication.class);
	
	public static void main(String args[]) {
		try {
			LOGGER.info("Begin SkillTrackerAddApplication - args: "+ args);
			SpringApplication.run(SkillTrackerAddApplication.class, args);
		} catch(Exception e) {
			LOGGER.error("Exception in SkillTrackerAddApplication: "+ e);
		}		
	}
}