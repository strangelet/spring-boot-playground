package krk.smog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

import krk.smog.entity.AirQuality;
import krk.smog.service.AirlyApiService;

/**
 * REST controller for checking weather condition.
 */
@Controller
@RequestMapping("krk/air/ui/")
public class UiController {

    @Autowired
    AirlyApiService apiService;

    @GetMapping("/24h")
    String getLast24HChart(Model model) {
        List<AirQuality> data24h = apiService.checkLast24Hours();
        model.addAttribute("airQualityDots", data24h);
        return "airquality.html";
    }


}
