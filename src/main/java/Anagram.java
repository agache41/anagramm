import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Anagram {

    /**
     * Set of characters to filter out of the anagram counts.
     */
    public static final Set<Integer> filteredChars = " ,:;'*+=(){}!§$%&/\"><|._-#`´?!".chars()
                                                                                      .boxed()
                                                                                      .collect(Collectors.toSet());

    /**
     * Tells if two texts are anagram of each other.
     *
     * @param textL the left Text to compare
     * @param textR the right Text to compare
     * @return true if the two texts are anagram of each other, false otherwise
     */
    public static boolean isAnagramOf(String textL, String textR) {
        return Objects.equals(Anagram.key(textL), Anagram.key(textR));
    }

    /**
     * Calculates an  Anagram Key for a given text.
     * It creates a unique representation of the text with regard to the anagram space.
     * Examples : a -> #97=1 , b -> #98=1 , foo -> #102=1#111=2 , angel -> #97=1#101=1#103=1#108=1#110=1 , glean -> #97=1#101=1#103=1#108=1#110=1 (same as angel)
     * The chosen format is #CharacterCode=Count repeated for every character and ordered by CharacterCode.
     * The text is converted to lowercase and some characters are being removed : ,:;'*+=(){}!§$%&/"><|._-#`´?! , this can be further configured.
     * @param text the text to calculate the anagram key for
     * @return the anagram key
     */
    public static String key(String text) {
        if (text == null) return null;
        return text.toLowerCase()
                   .chars()
                   .boxed()
                   .filter(Predicate.not(filteredChars::contains))
                   .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                   .entrySet()
                   .stream()
                   .sorted(Map.Entry.comparingByKey())
                   .map(entry -> "#" + entry.getKey() + "=" + entry.getValue())
                   .collect(Collectors.joining());
    }

    /**
     * Main launcher.
     * Use java Anagram textL textR to compare.
     *
     * @param args the prog arg
     */
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Not enough parameters! \r\n Use java Anagram textL textR to compare ");
            return;
        }
        if (isAnagramOf(args[0], args[1]))
            System.out.println(" The two texts are anagram-equal!");
        else
            System.out.println(" The two texts are not anagram-equal!");
    }
}
