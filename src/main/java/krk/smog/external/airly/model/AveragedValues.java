package krk.smog.external.airly.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.time.Instant;
import java.util.List;

/**
 * Java classes corresponding to data model of AIRLY API: https://developer.airly.eu/api.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class AveragedValues {

    /**
     * fromDateTime (string, optional):
     * Left bound of the time period over which average measurements
     * were calculated, inclusive, always UTC.
     *
     * Example of received time format: "2018-10-17T10:22:07.548Z".
     */
    private Instant fromDateTime;

    /**
     * tillDateTime (string, optional):
     * Right bound of the time period over which average measurements
     * were calculated, exclusive, always UTC.
     *
     * Example of received time format: "2018-10-17T10:22:07.548Z".
     */
    private Instant tillDateTime;

    /**
     * values (array [Value], optional):
     * List of raw measurements, averaged over specified period.
     * Measurement types available in this list depend on the capabilities
     * of the queried installation, e.g. particulate matter (PM1, PM25, PM10),
     * gases (CO, NO2, SO2, O3) or weather conditions (temperature, humidity, pressure).
     */
    private List<Value> values;

    /**
     * indexes (array [Index], optional):
     * List of indexes calculated from the values available. Indexes are defined
     * by relevant national and international institutions, e.g. EU, GIOŚ or US EPA.
     */
    private List<Index> indexes;

    /**
     * standards (array [Standard], optional):
     * List of 'standard' values, or 'limits' for pollutants that should not be
     * exceeded over certain period of time. Limits are defined by relevant national
     * and international institutions, like e.g. WHO or EPA.
     * For each standard limit in this list there is also a corresponding
     * measurement expressed as a percent value of the limit.
     */
    private List<Standard> standards;

    public AveragedValues() {
    }

    public Instant getFromDateTime() {
        return fromDateTime;
    }

    public void setFromDateTime(Instant fromDateTime) {
        this.fromDateTime = fromDateTime;
    }

    public Instant getTillDateTime() {
        return tillDateTime;
    }

    public void setTillDateTime(Instant tillDateTime) {
        this.tillDateTime = tillDateTime;
    }

    public List<Value> getValues() {
        return values;
    }

    public void setValues(List<Value> values) {
        this.values = values;
    }

    public List<Index> getIndexes() {
        return indexes;
    }

    public void setIndexes(List<Index> indexes) {
        this.indexes = indexes;
    }

    public List<Standard> getStandards() {
        return standards;
    }

    public void setStandards(List<Standard> standards) {
        this.standards = standards;
    }

    @Override
    public String toString() {
        return "AveragedValues{" +
                "fromDateTime='" + fromDateTime + '\'' +
                ", tillDateTime='" + tillDateTime + '\'' +
                ", values=" + values +
                ", indexes=" + indexes +
                ", standards=" + standards +
                '}';
    }
}
