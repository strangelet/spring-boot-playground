package krk.smog.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.Collections;

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

    /** Calling airly API and returning current condition. */
    public AirQuality checkCurrentCondition() {
        String airlyUrl = String.format(airlyBaseUrl, krkLat, krkLng);

        System.out.println("Let's check KRK in airly.eu:");

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.add("apikey", airlyEuApikey);
        HttpEntity<String> entity = new HttpEntity<>("parameters", headers);

        ResponseEntity<Measurements> measurements =
                restTemplate.exchange(airlyUrl, HttpMethod.GET, entity, Measurements.class);

        System.out.println(measurements.getBody().toString());

        // TODO(alena): move this logic to Spring batch
        AveragedValues currentValues = measurements.getBody().getCurrent();
        AirQuality point = new AirQuality();
        point.fromDateTime = currentValues.getFromDateTime();
        point.tillDateTime = currentValues.getTillDateTime();
        point.indexName = currentValues.getIndexes().get(0).getName();
        point.value = currentValues.getIndexes().get(0).getValue();
        point.level = currentValues.getIndexes().get(0).getLevel();
        point.description = currentValues.getIndexes().get(0).getDescription();
        point.advice = currentValues.getIndexes().get(0).getAdvice();
        point.color = currentValues.getIndexes().get(0).getColor();
        return point;
    }
}
