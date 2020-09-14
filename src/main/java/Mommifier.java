import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Mommifier {
    private static final double PERCENT = 0.3;
    private final List<Character> vowels = new ArrayList<>(Arrays.asList(
            'a', 'e', 'i', 'o', 'u',
            'A', 'E', 'I', 'O', 'U'
    ));

    public String mommify(String string) {
        if (string == null) {
            throw new IllegalArgumentException("Input should not be null");
        }
        if (string.isEmpty()) {
            throw new IllegalArgumentException("Input should not be empty string");
        }

        if (isVowelsMoreThan(string, PERCENT) && string.length() > 1) {
            return getMommifiedString(string);
        }
        return string;
    }

    private String getMommifiedString(String string) {
        StringBuilder result = new StringBuilder(string);
        int index = 1;
        while (index < result.length()) {
            if (hasContinuousVowelsAt(result, index)) {
                result.insert(index, "mommy");
                index += 5;
                continue;
            }
            index++;
        }
        return result.toString();
    }

    private boolean hasContinuousVowelsAt(StringBuilder result, int index) {
        int previous = index - 1;
        return vowels.contains(result.charAt(previous)) && vowels.contains(result.charAt(index));
    }

    private boolean isVowelsMoreThan(String string, double percent) {
        int count = 0;
        for (int index = 0; index < string.length(); index++) {
            if (vowels.contains(string.charAt(index))) {
                count++;
            }
        }
        return count > string.length() * percent;
    }
}
