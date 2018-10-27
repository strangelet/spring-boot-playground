package krk.smog.config;

import com.mongodb.MongoClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/** Configuration needed for Mongo connection. */
@Configuration
@Profile({"dev", "prod"})
@EnableMongoRepositories(basePackages = "krk.smog")
public class MongodbDataSourceConfig extends AbstractMongoConfiguration {

    @Value("${mongo.db.name}")
    private String mongoName;
    @Value("${mongo.db.host}")
    private String mongoHost;
    @Value("${mongo.db.port}")
    private Integer mongoPort;

    @Override
    public String getDatabaseName(){
        return mongoName;
    }

    @Override
    @Bean
    public MongoClient mongoClient() {
        return new MongoClient(mongoHost, mongoPort);
    }
}
