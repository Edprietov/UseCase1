package sort;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import dto.Country;

public class SortCountries {

    public String sort(String response, String how) {
        Stream<String> countries = Arrays.stream(response.split("},\\{")).map(x -> "{" + x + "}");

        List<Country> countriesList =
            new java.util.ArrayList<>(countries.map(
                    country -> new Country(country.substring(country.indexOf("n\":\""), country.indexOf("\",")).substring(4), country))
                .toList());

        countriesList.sort(
            (x, y) -> how.equals("ascend") ? x.getName().compareTo(y.getName()) : y.getName().compareTo(x.getName())
        );

        return countriesList.stream()
            .map(Country::getContent)
            .toList()
            .toString();
    }
}
