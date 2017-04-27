
package aiss.model.bing;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class InsightsSourcesSummary {

    private Integer shoppingSourcesCount;
    private Integer recipeSourcesCount;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Integer getShoppingSourcesCount() {
        return shoppingSourcesCount;
    }

    public void setShoppingSourcesCount(Integer shoppingSourcesCount) {
        this.shoppingSourcesCount = shoppingSourcesCount;
    }

    public Integer getRecipeSourcesCount() {
        return recipeSourcesCount;
    }

    public void setRecipeSourcesCount(Integer recipeSourcesCount) {
        this.recipeSourcesCount = recipeSourcesCount;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
