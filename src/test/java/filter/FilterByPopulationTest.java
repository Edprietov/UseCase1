package filter;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FilterByPopulationTest {

    private FilterByPopulation filterByPopulation = new FilterByPopulation();

    @Test
    public void filterByPopulationTest() {
        String input = "{{name\":{\"common\":\"Name1\",}, population\":120,},{name\":{\"common\":\"No\",}, population\":99,},{name\":{\"common\":\"Name2\",}, population\":10,}}";

        String output = filterByPopulation.filterByPopulation(input, 100);

        assertThat(output).isEqualTo("[{name\":{\"common\":\"No\",}, population\":99,}, {name\":{\"common\":\"Name2\",}, population\":10,}}}]");
    }

    @Test
    public void filterByPopulationNoMatchTest() {
        String input = "{{name\":{\"common\":\"Name1\",}, population\":120,},{name\":{\"common\":\"No\",}, population\":99,}, {name\":{\"common\":\"Name2\",}, population\":10,}}";

        String output = filterByPopulation.filterByPopulation(input, 1);

        assertThat(output).isEqualTo("[]");
    }


    @Test
    public void filterByPopulationEmptyTest() {
        String input = "[]";

        String output = filterByPopulation.filterByPopulation(input, 1);

        assertThat(output).isEqualTo("[]");
    }
}
