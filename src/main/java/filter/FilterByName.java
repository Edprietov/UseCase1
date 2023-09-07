package filter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import dto.Country;

public class FilterByName {

    public String filterByName(String response, String name) {
        Stream<String> country = Arrays.stream(response.split("},\\{")).map(x -> "{" + x + "}");

        List<Country> countries =
            country.map(x -> new Country(x.substring(x.indexOf("n\":\""), x.indexOf("\",")).substring(4), x)).toList();

        return countries.stream()
            .filter(x -> x.getName()
                .toLowerCase()
                .contains(name.toLowerCase())
            )
            .map(Country::getContent)
            .toList()
            .toString();
    }
}
