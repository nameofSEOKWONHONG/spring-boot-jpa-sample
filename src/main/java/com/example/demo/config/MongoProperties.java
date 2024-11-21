package com.example.demo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "spring.data.mongodb")
public class MongoProperties {

    private DatabaseConfig primary;
    private DatabaseConfig secondary;

    public static class DatabaseConfig {
        private String uri;
        private String database;

        // Getters and Setters
        public String getUri() {
            return uri;
        }

        public void setUri(String uri) {
            this.uri = uri;
        }

        public String getDatabase() {
            return database;
        }

        public void setDatabase(String database) {
            this.database = database;
        }
    }

    // Getters and Setters
    public DatabaseConfig getPrimary() {
        return primary;
    }

    public void setPrimary(DatabaseConfig primary) {
        this.primary = primary;
    }

    public DatabaseConfig getSecondary() {
        return secondary;
    }

    public void setSecondary(DatabaseConfig secondary) {
        this.secondary = secondary;
    }
}
