
package aiss.model.bing;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Instrumentation {

    private String pingUrlBase;
    private String pageLoadPingUrl;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String getPingUrlBase() {
        return pingUrlBase;
    }

    public void setPingUrlBase(String pingUrlBase) {
        this.pingUrlBase = pingUrlBase;
    }

    public String getPageLoadPingUrl() {
        return pageLoadPingUrl;
    }

    public void setPageLoadPingUrl(String pageLoadPingUrl) {
        this.pageLoadPingUrl = pageLoadPingUrl;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
