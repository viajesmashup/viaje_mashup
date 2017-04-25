
package aiss.model.weather;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Clouds {

private Integer all;
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

public Integer getAll() {
return all;
}

public void setAll(Integer all) {
this.all = all;
}

public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

}