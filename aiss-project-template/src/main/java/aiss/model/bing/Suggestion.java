
package aiss.model.bing;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Suggestion {

    private String text;
    private String displayText;
    private String webSearchUrl;
    private String webSearchUrlPingSuffix;
    private String searchLink;
    private Thumbnail__ thumbnail;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getDisplayText() {
        return displayText;
    }

    public void setDisplayText(String displayText) {
        this.displayText = displayText;
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

    public String getSearchLink() {
        return searchLink;
    }

    public void setSearchLink(String searchLink) {
        this.searchLink = searchLink;
    }

    public Thumbnail__ getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(Thumbnail__ thumbnail) {
        this.thumbnail = thumbnail;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
