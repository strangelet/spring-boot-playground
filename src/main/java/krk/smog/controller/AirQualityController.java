package krk.smog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import krk.smog.entity.AirQuality;
import krk.smog.service.AirQualityMongoService;
import krk.smog.service.AirlyApiService;

/**
 * REST controller for checking weather condition.
 */
@RestController
@RequestMapping("krk/air/")
public class AirQualityController {

    @Autowired
    AirlyApiService apiService;
    @Autowired
    AirQualityMongoService mongoService;

    @Cacheable("airly_now")
    @GetMapping(path = "now", produces = "application/json")
    public @ResponseBody
    AirQuality getCurrent() {
        return apiService.checkCurrentCondition();
    }

    @Cacheable("history")
    @GetMapping(path = "history", produces = "application/json")
    public @ResponseBody
    List<AirQuality> getAllHistory() {
        return mongoService.findAll();
    }
}
