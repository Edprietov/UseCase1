package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CountryController {

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/getCountries")
    public ResponseEntity<String> countries(@RequestParam(value = "name", required = false) String name,
        @RequestParam(value = "sort", required = false) String sort,
        @RequestParam(value = "population", required = false) Integer population,
        @RequestParam(value = "pagination", required = false) Integer pagination
    ) {
        String uriTemplate = "https://restcountries.com/v3.1/all";

        ResponseEntity<String> response = restTemplate.getForEntity(uriTemplate, String.class);

        return response;
    }
}
