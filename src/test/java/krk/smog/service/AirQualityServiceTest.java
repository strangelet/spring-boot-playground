package krk.smog.service;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import java.util.List;

import krk.smog.FongoTest;
import krk.smog.entity.AirQuality;
import krk.smog.external.airly.model.IndexLevel;

/**
 * Test for {@link AirQualityMongoService}. Uses in memory version of MongoDB.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@FongoTest
public class AirQualityServiceTest {

    @Autowired
    AirQualityMongoService service;

    @Test
    public void testEmptyDb() {
        assertTrue(service.findAll().isEmpty());
    }

    @Test
    public void testSingleRecordSaved() {
        service.save(getTestAirQuality());

        List<AirQuality> found = service.findAll();
        assertEquals(found.size(), 1);
        assertEquals(found.get(0).level, IndexLevel.HIGH);
        assertEquals(found.get(0).value, new Double(23.43));
        assertNotNull(found.get(0).id);
    }

    private AirQuality getTestAirQuality() {
        AirQuality airQuality = new AirQuality();
        airQuality.value = 23.43;
        airQuality.level = IndexLevel.HIGH;
        return airQuality;
    }
}
