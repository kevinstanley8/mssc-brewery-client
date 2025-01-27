package guru.springframework.msscbreweryclient.web.client;

import guru.springframework.msscbreweryclient.web.model.CustomerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class CustomerClientTest {

    @Autowired
    CustomerClient customerClient;


    @Test
    void getCustomerById() {
        CustomerDto customerDto = customerClient.getCustomerById(UUID.randomUUID());
        System.out.println("CUSTOMER : " + customerDto.toString());
        assertNotNull(customerDto);
    }

    @Test
    void testSaveNewCustomer() {
        URI uri = customerClient.saveNewCustomer(CustomerDto.builder().name("Stephanie Stanley").build());
        System.out.println("New Customer URI : " + uri.toString());
        assertNotNull(uri);
    }

    @Test
    void testUpdateCustomer() {
        customerClient.updateCustomer(UUID.randomUUID(), CustomerDto.builder().name("Alyssa Stanley").build());
    }

    @Test
    void testDeleteCustomer() {
        customerClient.deleteCustomer(UUID.randomUUID());
    }
}
