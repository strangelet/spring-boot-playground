package krk.smog.external.airly.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

/**
 * Java classes corresponding to data model of AIRLY API: https://developer.airly.eu/api.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Measurements {

    private AveragedValues current;
    private List<AveragedValues> history;
    private List<AveragedValues> forecast;

    public Measurements() {
    }

    public AveragedValues getCurrent() {
        return current;
    }

    public void setCurrent(AveragedValues current) {
        this.current = current;
    }

    public List<AveragedValues> getHistory() {
        return history;
    }

    public void setHistory(List<AveragedValues> history) {
        this.history = history;
    }

    public List<AveragedValues> getForecast() {
        return forecast;
    }

    public void setForecast(List<AveragedValues> forecast) {
        this.forecast = forecast;
    }

    @Override
    public String toString() {
        return "Measurements{" +
                "current=" + current +
                ", history=" + history +
                ", forecast=" + forecast +
                '}';
    }
}
