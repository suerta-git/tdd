import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MommifierTest {

    @Test
    void should_throw_when_given_null() {
        Mommifier mommifier = new Mommifier();
        final Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            String actual = mommifier.mommify(null);
        });
        assertEquals(exception.getMessage(), "Input should not be null");
    }

    @Test
    void should_throw_when_given_empty_string() {
        Mommifier mommifier = new Mommifier();
        final Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            String actual = mommifier.mommify("");
        });
        assertEquals(exception.getMessage(), "Input should not be empty string");
    }

    @Test
    void should_return_self_string_when_mommify_given_string_with_vowels_less_than_30_percent() {
        Mommifier mommifier = new Mommifier();
        final String actual = mommifier.mommify("should be itself________");
        assertEquals("should be itself________", actual);
    }
}
