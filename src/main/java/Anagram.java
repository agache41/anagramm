import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Anagram {
    public static String key(String text) {
        if (text == null) return null;
        return text.chars()
                   .boxed()
                   .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                   .entrySet()
                   .stream()
                   .sorted(Map.Entry.comparingByKey())
                   .map(entry -> "#" + entry.getKey() + "=" + entry.getValue())
                   .collect(Collectors.joining());
    }

    public static boolean isAnagramOf(String textL, String textR) {
        return Objects.equals(Anagram.key(textL), Anagram.key(textR));
    }


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
