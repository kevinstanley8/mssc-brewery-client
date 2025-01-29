package guru.springframework.msscbreweryclient.web.client;

import guru.springframework.msscbreweryclient.web.model.BeerDto;
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
public class BreweryClient {
    private final RestTemplate restTemplate;
    @Autowired
    AdditionalProperties additionalProperties;

    public BreweryClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public BeerDto getBeerById(UUID uuid) {
        return restTemplate.getForObject( additionalProperties.getApihost() + additionalProperties.getBeerApiPath() + "/" + uuid.toString(), BeerDto.class);
    }

    public URI saveNewBeer(BeerDto beerDto) {
        return restTemplate.postForLocation(additionalProperties.getApihost() + additionalProperties.getBeerApiPath(), beerDto);
    }

    public void updateBeer(UUID uuid, BeerDto beerDto) {
        restTemplate.put(additionalProperties.getApihost() + additionalProperties.getBeerApiPath() + "/" + uuid.toString(), beerDto);
    }

    public void deleteBeer(UUID uuid) {
        restTemplate.delete(additionalProperties.getApihost() + additionalProperties.getBeerApiPath() + "/" + uuid.toString());
    }
}
