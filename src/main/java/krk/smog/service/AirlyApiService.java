package krk.smog.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import krk.smog.entity.AirQuality;
import krk.smog.external.airly.model.AveragedValues;
import krk.smog.external.airly.model.Measurements;

/**
 * Service for making online calls to airly API.
 */
@Service
public class AirlyApiService {

    @Value("${AIRLY_EU_APIKEY}")
    private String airlyEuApikey;
    @Value("${airly.base.url}")
    private String airlyBaseUrl;
    @Value("${krk.lat}")
    private Double krkLat;
    @Value("${krk.lng}")
    private Double krkLng;

    /**
     * Calling airly API and returning current condition.
     */
    public AirQuality checkCurrentCondition() {
        String airlyUrl = String.format(airlyBaseUrl, krkLat, krkLng);
        System.out.println("Let's check KRK in airly.eu: " + airlyUrl);

        ResponseEntity<Measurements> measurements = new RestTemplate()
                .exchange(airlyUrl, HttpMethod.GET, buildEntity(airlyEuApikey), Measurements.class);

        return transformToAirQuality(measurements.getBody().getCurrent());
    }

    public List<AirQuality> checkLast24Hours() {
        String airlyUrl = String.format(airlyBaseUrl, krkLat, krkLng);
        System.out.println("Let's check KRK in airly.eu: " + airlyUrl);

        ResponseEntity<Measurements> measurements = new RestTemplate()
                .exchange(airlyUrl, HttpMethod.GET, buildEntity(airlyEuApikey), Measurements.class);

        return transformToAirQualityHistory(measurements.getBody().getHistory());
    }

    private static HttpEntity<String> buildEntity(String apiKey) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.add("apikey", apiKey);
        HttpEntity<String> entity = new HttpEntity<>("parameters", headers);
        return entity;
    }

    private static AirQuality transformToAirQuality(AveragedValues value) {
        AirQuality point = new AirQuality();
        point.fromDateTime = value.getFromDateTime();
        point.tillDateTime = value.getTillDateTime();
        point.indexName = value.getIndexes().get(0).getName();
        point.value = value.getIndexes().get(0).getValue();
        point.level = value.getIndexes().get(0).getLevel();
        point.description = value.getIndexes().get(0).getDescription();
        point.advice = value.getIndexes().get(0).getAdvice();
        point.color = value.getIndexes().get(0).getColor();
        return point;
    }

    private static List<AirQuality> transformToAirQualityHistory(List<AveragedValues> history) {
        List<AirQuality> airQualityHistory = new ArrayList<>();
        for (AveragedValues value : history) {
            airQualityHistory.add(transformToAirQuality(value));
        }
        return airQualityHistory;
    }
}
