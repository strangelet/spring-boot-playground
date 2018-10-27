package krk.smog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import krk.smog.entity.AirQuality;
import krk.smog.repository.AirQualityRepository;

/**
 * Service for processing AirQuality data.
 */
@Service
public class AirQualityMongoService {

    @Autowired
    private AirQualityRepository repository;

    public void save(AirQuality airQuality) {
        repository.save(airQuality);
    }

    public void saveAll(List<AirQuality> airQualities) {
        repository.saveAll(airQualities);
    }

    public List<AirQuality> findAll() {
        System.out.println("Retrieving history from the DB.");
        return repository.findAll();
    }
}
