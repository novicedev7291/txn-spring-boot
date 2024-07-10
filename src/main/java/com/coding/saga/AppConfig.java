package com.coding.saga;

import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.flyway.FlywayMigrationInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class AppConfig {
    @Value("${flyway.migrations.locations}")
    private String flywayMigrationsLocation;

    @Bean
    public Flyway flyway(DataSource ds) {
        return Flyway.configure().locations(flywayMigrationsLocation).dataSource(ds).load();
    }

    @Bean
    public FlywayMigrationInitializer flywayMigrationInitializer(Flyway flyway) {
        return new FlywayMigrationInitializer(flyway);
    }
}