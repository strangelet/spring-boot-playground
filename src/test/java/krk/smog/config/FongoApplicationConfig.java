package krk.smog.config;

import com.github.fakemongo.Fongo;
import com.mongodb.MongoClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * MongoTemplate and other Mongo related dependencies are taken care of automatically. In
 * mongoClient() method Fongo’s instance is returned which will act as mock MongoDB.
 */
@TestConfiguration
@Profile("test")
@EnableMongoRepositories(basePackages = "krk.smog")
@ComponentScan(basePackages = "krk.smog")
public class FongoApplicationConfig extends AbstractMongoConfiguration {

    @Value("${mongo.db.name}")
    private String mongoName;

    @Override
    protected String getDatabaseName() {
        return mongoName;
    }

    @Override
    public MongoClient mongoClient() {
        return new Fongo(getDatabaseName()).getMongo();
    }
}
