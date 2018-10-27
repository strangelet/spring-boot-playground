package krk.smog.config;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Profile;

@TestConfiguration
@Profile("test")
public class TestApplicationConfig {

    static {
        System.setProperty("AIRLY_EU_APIKEY", "dummy_api_key");
    }
}
