package krk.smog.external.airly.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Java classes corresponding to data model of AIRLY API: https://developer.airly.eu/api.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Value {

    /**
     * name (string, optional): Name of this measurement.
     */
    private ValueName name;

    /**
     * value (number, optional): Value of this measurement.
     */
    private String value;

    public Value() {
    }

    public ValueName getName() {
        return name;
    }

    public void setName(ValueName name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Value{" +
                "name='" + name + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
