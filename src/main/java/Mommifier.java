import javax.lang.model.util.Types;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

public class Mommifier {
    final private List<Character> vowels = new ArrayList<>(Arrays.asList(
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

        if (isVowelsMoreThan(string, 0.3) && string.length() > 1) {
            StringBuilder result = new StringBuilder(string);
            int previous = 0, index = 1;
            while (index < result.length()) {
                if (vowels.contains(result.charAt(previous)) && vowels.contains(result.charAt(index))) {
                    result.insert(index, "mommy");
                    previous += 5;
                    index += 5;
                    continue;
                }
                previous++;
                index++;
            }
            return result.toString();
        }
        return string;
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
