package com.skill.tracker.monogdb.connection;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.ServerApi;
import com.mongodb.ServerApiVersion;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

@Configuration
public class DbConnectionConfig {
	
	private static final Logger LOGGER = LogManager.getLogger(DbConnectionConfig.class);
	
	@Value("${spring.data.mongodb.uri}")
	private String monogDbUri;
	
	@Value("${spring.data.mongodb.database}")
	private String mongoDbName;

	@Bean
	public MongoDatabase getMonogDbConnection() {
		LOGGER.info("Begin AddProfileDAO getMonogDbConnection() - monogDbUri:" +monogDbUri+ " mongoDbName: "+mongoDbName);
		
		ConnectionString connectionString = new ConnectionString(monogDbUri);
		MongoClientSettings settings = MongoClientSettings.builder().applyConnectionString(connectionString)
				.serverApi(ServerApi.builder().version(ServerApiVersion.V1).build()).build();
		MongoClient mongoClient = MongoClients.create(settings);
		MongoDatabase database = mongoClient.getDatabase(mongoDbName);
		return database;
	}
}
