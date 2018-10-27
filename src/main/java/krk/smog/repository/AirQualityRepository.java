package krk.smog.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import krk.smog.entity.AirQuality;

/**
 * Repository for accessing Air Quality data saved in mongo.
 */
@Repository
public interface AirQualityRepository extends MongoRepository<AirQuality, String> {

    List<AirQuality> findAll();
    // TODO(alena): add method to find all air quality data in certain time window.
}
