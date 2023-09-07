package filter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import dto.Country;

public class FilterByName {

    public String filterByName(String response, String name) {
        Stream<String> countries = Arrays.stream(response.split("},\\{")).map(x -> "{" + x + "}");

        List<Country> countriesList =
            countries.map(
                    country -> new Country(country.substring(country.indexOf("n\":\""), country.indexOf("\",")).substring(4), country))
                .toList();

        return countriesList.stream()
            .filter(x -> x.getName()
                .toLowerCase()
                .contains(name.toLowerCase())
            )
            .map(Country::getContent)
            .toList()
            .toString();
    }
}
