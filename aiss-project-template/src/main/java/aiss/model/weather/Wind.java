package aiss.model.weather;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown=true)

public class Wind {

private Double speed;
private Integer deg;
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

public Double getSpeed() {
return speed;
}

public void setSpeed(Double speed) {
this.speed = speed;
}

public Integer getDeg() {
return deg;
}

public void setDeg(Integer deg) {
this.deg = deg;
}

public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

}


