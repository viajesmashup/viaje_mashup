
package aiss.model.bing;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Photo {

    private String type;
    private Instrumentation instrumentation;
    private String readLink;
    private String webSearchUrl;
    private String webSearchUrlPingSuffix;
    private Integer totalEstimatedMatches;
    private List<Value> value = null;
    private List<QueryExpansion> queryExpansions = null;
    private Integer nextOffsetAddCount;
    private List<PivotSuggestion> pivotSuggestions = null;
    private Boolean displayShoppingSourcesBadges;
    private Boolean displayRecipeSourcesBadges;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Instrumentation getInstrumentation() {
        return instrumentation;
    }

    public void setInstrumentation(Instrumentation instrumentation) {
        this.instrumentation = instrumentation;
    }

    public String getReadLink() {
        return readLink;
    }

    public void setReadLink(String readLink) {
        this.readLink = readLink;
    }

    public String getWebSearchUrl() {
        return webSearchUrl;
    }

    public void setWebSearchUrl(String webSearchUrl) {
        this.webSearchUrl = webSearchUrl;
    }

    public String getWebSearchUrlPingSuffix() {
        return webSearchUrlPingSuffix;
    }

    public void setWebSearchUrlPingSuffix(String webSearchUrlPingSuffix) {
        this.webSearchUrlPingSuffix = webSearchUrlPingSuffix;
    }

    public Integer getTotalEstimatedMatches() {
        return totalEstimatedMatches;
    }

    public void setTotalEstimatedMatches(Integer totalEstimatedMatches) {
        this.totalEstimatedMatches = totalEstimatedMatches;
    }

    public List<Value> getValue() {
        return value;
    }

    public void setValue(List<Value> value) {
        this.value = value;
    }

    public List<QueryExpansion> getQueryExpansions() {
        return queryExpansions;
    }

    public void setQueryExpansions(List<QueryExpansion> queryExpansions) {
        this.queryExpansions = queryExpansions;
    }

    public Integer getNextOffsetAddCount() {
        return nextOffsetAddCount;
    }

    public void setNextOffsetAddCount(Integer nextOffsetAddCount) {
        this.nextOffsetAddCount = nextOffsetAddCount;
    }

    public List<PivotSuggestion> getPivotSuggestions() {
        return pivotSuggestions;
    }

    public void setPivotSuggestions(List<PivotSuggestion> pivotSuggestions) {
        this.pivotSuggestions = pivotSuggestions;
    }

    public Boolean getDisplayShoppingSourcesBadges() {
        return displayShoppingSourcesBadges;
    }

    public void setDisplayShoppingSourcesBadges(Boolean displayShoppingSourcesBadges) {
        this.displayShoppingSourcesBadges = displayShoppingSourcesBadges;
    }

    public Boolean getDisplayRecipeSourcesBadges() {
        return displayRecipeSourcesBadges;
    }

    public void setDisplayRecipeSourcesBadges(Boolean displayRecipeSourcesBadges) {
        this.displayRecipeSourcesBadges = displayRecipeSourcesBadges;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
