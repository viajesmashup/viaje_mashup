
package aiss.model.weather;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown=true)
public class Main {

    private Double temp;
    private Double temp_min;
    private Double temp_max;
    private Double pressure;
    private Double seaLevel;
    private Double grndLevel;
    private Integer humidity;
    private Integer tempKf;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Double getTemp() {
        return temp;
    }

    public void setTemp(Double temp) {
        this.temp = temp;
    }

    public Double getTemp_min() {
        return temp_min;
    }

    public void setTemp_min(Double tempMin) {
        this.temp_min = tempMin;
    }

    public Double getTemp_max() {
        return temp_max;
    }

    public void setTemp_max(Double tempMax) {
        this.temp_max = tempMax;
    }

    public Double getPressure() {
        return pressure;
    }

    public void setPressure(Double pressure) {
        this.pressure = pressure;
    }

    public Double getSeaLevel() {
        return seaLevel;
    }

    public void setSeaLevel(Double seaLevel) {
        this.seaLevel = seaLevel;
    }

    public Double getGrndLevel() {
        return grndLevel;
    }

    public void setGrndLevel(Double grndLevel) {
        this.grndLevel = grndLevel;
    }

    public Integer getHumidity() {
        return humidity;
    }

    public void setHumidity(Integer humidity) {
        this.humidity = humidity;
    }

    public Integer getTempKf() {
        return tempKf;
    }

    public void setTempKf(Integer tempKf) {
        this.tempKf = tempKf;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
