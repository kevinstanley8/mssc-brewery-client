package guru.springframework.msscbreweryclient.web.client;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "sfg.brewery")
public class AdditionalProperties {

    private String apihost;
    private String beerApiPath;
    private String customerApiPath;

    public String getApihost() {
        return apihost;
    }

    public void setApihost(String apihost) {
        this.apihost = apihost;
    }

    public String getBeerApiPath() {
        return beerApiPath;
    }

    public void setBeerApiPath(String beerApiPath) {
        this.beerApiPath = beerApiPath;
    }

    public String getCustomerApiPath() {
        return customerApiPath;
    }

    public void setCustomerApiPath(String customerApiPath) {
        this.customerApiPath = customerApiPath;
    }
}