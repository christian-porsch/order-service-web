package de.neuefische.orderserviceweb.controller;

import de.neuefische.orderserviceweb.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import de.neuefische.orderserviceweb.model.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;



import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProductControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private ProductRepository repository;

    @Autowired
    TestRestTemplate restTemplate;

    @Test
    void listAllProducts() {
        //Given

        //When
        List<Product> expected = repository.listAllProducts();
        //List<Product> expected = new ArrayList<Product>{};

        String host = "http://localhost:" + port;


        String hostProductUrl = host + "/product";
        ResponseEntity<Product[]> response = restTemplate.getForEntity(hostProductUrl, Product[].class);
        List<Product> actual = Arrays.asList(response.getBody());
        //Then
        assertThat(response.getStatusCode(), is(HttpStatus.OK));
        //assertEquals(HttpStatus.OK, response.getStatusCode());
        assertThat(actual, containsInAnyOrder(
                new Product("1", "Goldener Apfel"),
                new Product("2", "Bio Fairtrade Kakao mit Blutdiamanten"),
                new Product("3", "Gewoehnlicher Tee, aber mit Goldplaettchen"),
                new Product("4", "(Sehr) teurer Kaffee")
        ));

    }

    @Test
    void getProductById() {
    }

    @Test
    void addProduct() {
    }
}


//DirtyReinKopiert
    /*
private final String coronaIncidenceUrl = "https://api.covid19api.com/country/";
    private final String coronaIncidenceUrlRest = "/status/confirmed?from=2021-04-26T00:00:00Z&to=2021-04-26T23:59:59Z";
    private final RestTemplate restTemplate = new RestTemplate();

    public Optional<CoronaIncidence[]> getCasesByCountry(String country) {
        String coronaCountryIncidenceUrl = coronaIncidenceUrl + country + coronaIncidenceUrlRest;
        ResponseEntity<CoronaIncidence[]> response = restTemplate.getForEntity(coronaCountryIncidenceUrl, CoronaIncidence[].class);

        if(response.getBody() != null){
            return  Optional.of(response.getBody());
        }
        return Optional.empty();
    }
    */