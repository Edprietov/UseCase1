package pagination;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import dto.Country;

public class Paginator {

    public String paginate(String response, Integer pagination) {
        if(response.equals("[]")) {
            return response;
        }
        Stream<String> auxiliar = Arrays.stream(response.split("},\\s?\\{")).map(x -> "{" + x + "}");

        return auxiliar
            .limit(pagination)
            .toList()
            .toString();
    }
}
