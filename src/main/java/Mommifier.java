public class Mommifier {
    public String mommify(String string) {
        if (string == null) {
            throw new IllegalArgumentException("Input should not be null");
        }
        if (string.isEmpty()) {
            throw new IllegalArgumentException("Input should not be empty string");
        }
        return string;
    }
}
