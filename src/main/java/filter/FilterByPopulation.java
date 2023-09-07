package filter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import dto.Country;

public class FilterByPopulation {

    public String filterByPopulation(String response, Integer population) {
        Stream<String> countries = Arrays.stream(response.split("},\\s?\\{")).map(x -> "{" + x + "}");

        List<Country> countriesList =
            countries.map(
                    country -> new Country(
                        getPopulation(country), country))
                .toList();

        return countriesList.stream()
            .filter(x -> x.getPopulation() < population)
            .map(Country::getContent)
            .toList()
            .toString();
    }

    private Integer getPopulation(String country) {
        String aux = country.substring(country.indexOf("population\":")).substring(12);
        return Integer.parseInt(aux.substring(0, aux.indexOf(",")));
    }
}
