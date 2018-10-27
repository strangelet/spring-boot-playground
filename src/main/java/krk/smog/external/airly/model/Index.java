package krk.smog.external.airly.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Java classes corresponding to data model of AIRLY API: https://developer.airly.eu/api.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Index {

    /**
     * name (string, optional):
     * Name of this index.
     */
    private IndexName name;

    /**
     * value (number, optional):
     * Index numerical value.
     */
    private Double value;

    /**
     * level (string, optional):
     * Index level name.
     */
    private IndexLevel level;

    /**
     * description (string, optional):
     * Text describing this air quality level. Text translation is returned
     * according to language specified in the request (English being default).
     */
    private String description;

    /**
     * advice (string, optional):
     * Piece of advice from Airly regarding air quality.
     * Text translation is returned according to language specified
     * in the request (English being default).
     */
    private String advice;

    /**
     * color (string, optional):
     * Color representing this index level, given by hexadecimal css-style triplet.
     */
    private String color;

    public Index() {
    }

    public IndexName getName() {
        return name;
    }

    public void setName(IndexName name) {
        this.name = name;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public IndexLevel getLevel() {
        return level;
    }

    public void setLevel(IndexLevel level) {
        this.level = level;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAdvice() {
        return advice;
    }

    public void setAdvice(String advice) {
        this.advice = advice;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Index{" +
                "name='" + name + '\'' +
                ", value=" + value +
                ", level='" + level + '\'' +
                ", description='" + description + '\'' +
                ", advice='" + advice + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
