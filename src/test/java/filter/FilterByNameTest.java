package filter;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FilterByNameTest {

    private FilterByName filterByName = new FilterByName();

    @Test
    public void filterByNameTest() {
        String input = "{{name\":{\"common\":\"Name1\",}},{name\":{\"common\":\"No\",}},{name\":{\"common\":\"Name2\",}}}";

        String output = filterByName.filterByName(input, "am");

        assertThat(output).isEqualTo("[{{{name\":{\"common\":\"Name1\",}}, {name\":{\"common\":\"Name2\",}}}}]");
    }

    @Test
    public void filterByNameNoMatchTest() {
        String input = "{{name\":{\"common\":\"Name1\",}},{name\":{\"common\":\"No\",}},{name\":{\"common\":\"Name2\",}}}";

        String output = filterByName.filterByName(input, "otherName");

        assertThat(output).isEqualTo("[]");
    }
}
