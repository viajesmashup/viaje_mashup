
package aiss.model.bing;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class PivotSuggestion {

    private String pivot;
    private List<Suggestion> suggestions = null;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String getPivot() {
        return pivot;
    }

    public void setPivot(String pivot) {
        this.pivot = pivot;
    }

    public List<Suggestion> getSuggestions() {
        return suggestions;
    }

    public void setSuggestions(List<Suggestion> suggestions) {
        this.suggestions = suggestions;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
