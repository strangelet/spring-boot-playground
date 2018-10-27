package krk.smog.external.airly.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Java classes corresponding to data model of AIRLY API: https://developer.airly.eu/api.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Standard {

    /**
     * name (string, optional): Name of this standard.
     */
    private String name;

    /**
     * pollutant (string, optional): Pollutant described by this standard.
     */
    private String pollutant;

    /**
     * limit (number, optional): Limit value of the pollutant.
     */
    private Double limit;

    /**
     * percent (number, optional): Pollutant measurement as percent of allowable limit.
     */
    private Double percent;

    public Standard() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPollutant() {
        return pollutant;
    }

    public void setPollutant(String pollutant) {
        this.pollutant = pollutant;
    }

    public Double getLimit() {
        return limit;
    }

    public void setLimit(Double limit) {
        this.limit = limit;
    }

    public Double getPercent() {
        return percent;
    }

    public void setPercent(Double percent) {
        this.percent = percent;
    }

    @Override
    public String toString() {
        return "Standard{" +
                "name='" + name + '\'' +
                ", pollutant='" + pollutant + '\'' +
                ", limit=" + limit +
                ", percent=" + percent +
                '}';
    }
}
