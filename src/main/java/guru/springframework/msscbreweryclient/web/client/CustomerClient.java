package guru.springframework.msscbreweryclient.web.client;

import guru.springframework.msscbreweryclient.web.model.CustomerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.UUID;

@Component
@Configuration
@EnableConfigurationProperties(AdditionalProperties.class)
public class CustomerClient {
    private final RestTemplate restTemplate;
    @Autowired
    AdditionalProperties additionalProperties;

    public CustomerClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public CustomerDto getCustomerById(UUID uuid) {
        return restTemplate.getForObject(additionalProperties.getApihost() + additionalProperties.getCustomerApiPath() + "/" + uuid.toString(), CustomerDto.class);
    }

    public URI saveNewCustomer(CustomerDto customerDto) {
        return restTemplate.postForLocation(additionalProperties.getApihost() + additionalProperties.getCustomerApiPath(), customerDto);
    }

    public void updateCustomer(UUID uuid, CustomerDto customerDto) {
        restTemplate.put(additionalProperties.getApihost() + additionalProperties.getCustomerApiPath() + "/" + uuid.toString(), customerDto);
    }

    public void deleteCustomer(UUID uuid) {
        restTemplate.delete(additionalProperties.getApihost() + additionalProperties.getCustomerApiPath() + "/" + uuid.toString());
    }



}
