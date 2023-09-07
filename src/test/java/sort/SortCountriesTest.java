package sort;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SortCountriesTest {

    private SortCountries sortCountries = new SortCountries();

    @Test
    public void sortCountriesAZTest() {
        String input = "{{name\":{\"common\":\"Peru\",}},{name\":{\"common\":\"Ukraine\",}},{name\":{\"common\":\"Colombia\",}}}";
        String expected = "[{name\":{\"common\":\"Colombia\",}}}}, {{{name\":{\"common\":\"Peru\",}}, {name\":{\"common\":\"Ukraine\",}}]";

        String actual = sortCountries.sort(input, "ascend");

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void sortCountriesZATest() {
        String input = "{{name\":{\"common\":\"Peru\",}}, {name\":{\"common\":\"Ukraine\",}}, {name\":{\"common\":\"Colombia\",}}}";
        String expected = "[{name\":{\"common\":\"Ukraine\",}}, {{{name\":{\"common\":\"Peru\",}}, {name\":{\"common\":\"Colombia\",}}}}]";

        String actual = sortCountries.sort(input, "descend");

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void sortCountriesEmptyTest() {
        String input = "[]";

        String actual = sortCountries.sort(input, "descend");

        assertThat(actual).isEqualTo(input);
    }
}
