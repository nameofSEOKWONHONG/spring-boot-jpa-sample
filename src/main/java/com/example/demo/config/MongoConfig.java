package com.example.demo.config;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
public class MongoConfig {
    private final MongoProperties mongoProperties;

    public MongoConfig(MongoProperties mongoProperties) {
        this.mongoProperties = mongoProperties;
    }

    @Bean
    public MongoTemplate primaryMongoTemplate() {
        MongoProperties.DatabaseConfig primary = mongoProperties.getPrimary();
        MongoClient mongoClient = MongoClients.create(primary.getUri());
        return new MongoTemplate(mongoClient, primary.getDatabase());
    }

    @Bean
    public MongoTemplate secondaryMongoTemplate() {
        MongoProperties.DatabaseConfig secondary = mongoProperties.getSecondary();
        MongoClient mongoClient = MongoClients.create(secondary.getUri());
        return new MongoTemplate(mongoClient, secondary.getDatabase());
    }
}