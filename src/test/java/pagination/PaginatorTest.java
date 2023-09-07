package pagination;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PaginatorTest {

    private Paginator paginator = new Paginator();

    @Test
    public void paginateTest() {
        String input = "{{name\":{\"common\":\"Name1\",}}, {name\":{\"common\":\"No\",}},{name\":{\"common\":\"Name2\",}}}";

        String actual = paginator.paginate(input, 1);

        assertThat(actual).isEqualTo("[{{{name\":{\"common\":\"Name1\",}}]");
    }

    @Test
    public void paginateHigherNumberTest() {
        String input = "{{name\":{\"common\":\"Name1\",}},{name\":{\"common\":\"No\",}},{name\":{\"common\":\"Name2\",}}}";

        String actual = paginator.paginate(input, 5);

        assertThat(actual).isEqualTo(
            "[{{{name\":{\"common\":\"Name1\",}}, {name\":{\"common\":\"No\",}}, {name\":{\"common\":\"Name2\",}}}}]");
    }

    @Test
    public void paginateEmptyTest() {
        String input = "[]";

        String actual = paginator.paginate(input, 1);

        assertThat(actual).isEqualTo("[]");
    }
}
