package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import filter.FilterByName;
import filter.FilterByPopulation;
import pagination.Paginator;
import sort.SortCountries;

@RestController
public class CountryController {

    @Autowired
    RestTemplate restTemplate;

    FilterByName filterByName = new FilterByName();

    FilterByPopulation filterByPopulation = new FilterByPopulation();

    Paginator paginator = new Paginator();

    SortCountries sortCountries = new SortCountries();

    @GetMapping("/getCountries")
    public ResponseEntity<String> countries(@RequestParam(value = "name", required = false) String name,
        @RequestParam(value = "sort", required = false) String sort,
        @RequestParam(value = "population", required = false) Integer population,
        @RequestParam(value = "pagination", required = false) Integer pagination
    ) {
        String uriTemplate = "https://restcountries.com/v3.1/all";

        String response = restTemplate.getForEntity(uriTemplate, String.class).getBody();

        if (name != null) {
            response = filterByName.filterByName(response, name);
        }

        if (population != null) {
            response = filterByPopulation.filterByPopulation(response, population);
        }

        if (sort != null) {
            response = sortCountries.sort(response, sort);
        }

        if (pagination != null) {
            response = paginator.paginate(response, pagination);
        }

        return ResponseEntity.ok(response);
    }
}
