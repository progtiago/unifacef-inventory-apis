package edu.unifacef.inventoryapi.configurations.mongodb;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoAuditing
@EnableMongoRepositories(basePackages = {"edu.unifacef.inventoryapi.gateways.outputs.mongodb"})
public class MongoDbConfiguration {}
