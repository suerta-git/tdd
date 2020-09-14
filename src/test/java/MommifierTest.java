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
}
