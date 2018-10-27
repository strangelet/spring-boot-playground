package krk.smog.entity;

import org.springframework.data.annotation.Id;
import java.time.Instant;

import krk.smog.external.airly.model.IndexLevel;
import krk.smog.external.airly.model.IndexName;

/**
 * Entity object for persisting AirQuality info in MongoDB.
 */
public class AirQuality {

    @Id
    public String id;

    /**
     * Left bound of the time period over which average measurements were calculated, inclusive,
     * always UTC.
     */
    public Instant fromDateTime;

    /**
     * Right bound of the time period over which average measurements were calculated, exclusive,
     * always UTC.
     */
    public Instant tillDateTime;

    /**
     * Name of this index.
     */
    public IndexName indexName;

    /**
     * Index numerical value.
     */
    public Double value;

    /**
     * Index level indexName.
     */
    public IndexLevel level;

    /**
     * Text describing this air quality level. Text translation is returned according to language
     * specified in the request (English being default).
     */
    public String description;

    /**
     * Piece of advice from Airly regarding air quality. Text translation is returned according to
     * language specified in the request (English being default).
     */
    public String advice;

    /**
     * Color representing this index level, given by hexadecimal css-style triplet.
     */
    public String color;

    public AirQuality() {
    }

    @Override
    public String toString() {
        return "AirQuality{"
                + "id='"
                + id
                + '\''
                + ", fromDateTime="
                + fromDateTime
                + ", tillDateTime="
                + tillDateTime
                + ", indexName="
                + indexName
                + ", value="
                + value
                + ", level="
                + level
                + ", description='"
                + description
                + '\''
                + ", advice='"
                + advice
                + '\''
                + ", color='"
                + color
                + '\''
                + '}';
    }
}
