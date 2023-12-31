import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class AnagramTest {

    @ParameterizedTest
    @CsvSource({
            ",",
            "a,#97=1",
            "b,#98=1",
            "foo,#102=1#111=2",
            "angel,#97=1#101=1#103=1#108=1#110=1",
            "glean,#97=1#101=1#103=1#108=1#110=1",
            "arc,#97=1#99=1#114=1",
            "car,#97=1#99=1#114=1",
            "brag,#97=1#98=1#103=1#114=1",
            "grab,#97=1#98=1#103=1#114=1",
            "bored,#98=1#100=1#101=1#111=1#114=1",
            "robed,#98=1#100=1#101=1#111=1#114=1",
            "cat,#97=1#99=1#116=1",
            "act,#97=1#99=1#116=1",
            "cider,#99=1#100=1#101=1#105=1#114=1",
            "cried,#99=1#100=1#101=1#105=1#114=1"})
    public void testKey(String text, String key) {
        Assertions.assertEquals(key, Anagram.key(text), " Wrong generated key for " + text);
    }

    @ParameterizedTest
    @CsvSource(value = {"angel = glean",
            "arc = car",
            "brag = grab",
            "bored = robed",
            "cat = act",
            "cider = cried",
            "dusty = study",
            "elbow = below",
            "inch = chin",
            "night = thing",
            "peach = cheap",
            "players = parsley",
            "sadder = dreads",
            "save = vase",
            "state = taste",
            "a gentleman = elegant man",
            "astronomer = moon starer",
            "Christmas = trims cash",
            "conversation = voices rant on",
            "dormitory = dirty room",
            "eleven plus two = twelve plus one",
            "Fourth of July = joyful Fourth",
            "listen = silent",
            "schoolmaster = the classroom",
            "slot machines = cash lost in 'em",
            "snooze alarms = alas, no more Z's",
            "the detectives = detect thieves",
            "the eyes = they see",
            "the Morse Code = here come dots",
            "vacation time = I am not active",
            "Clint Eastwood = old west action",
            "Elvis Presley = Presley lives",
            "Emily Dickinson = income is kindly",
            "George Bush = he bugs Gore",
            "Jim Morrison = Mr. Mojo Risin'",
            "Madam Curie = radium mace",
            "Madonna Louise Ciccone = one cool dance musician",
            "Michael Jordan = jam on, rich deal",
            "Ronald Reagan = A darn long era",
            "Russell Crowe = scowler rules",
            "Saoirse Ronan = rare as onions",
            "Shaquille O'Neal = one equals a hill",
            "Thomas Edison = notes said \"Ohm\"",
            "T.S. Eliot = toilets",
            "William Shakespeare = I'll make a wise phrase"},
            delimiterString = " = ")
    public void testCompareEqual(String textL, String textR) {
        Assertions.assertTrue(Anagram.isAnagramOf(textL,textR), " The two text are anagram of each other: " + textL+"("+Anagram.key(textL)+")"+ "~=" + textR+"("+Anagram.key(textR)+")");
    }

    @ParameterizedTest
    @CsvSource(value = {"angel = gglean",
            "arc = caar",
            "brag = grad",
            "bored = rodbed",
            "cat = at",
            "cider = crded",
            "dusty = ",
            "elbow = belowbelow",
            "inch = chinch",
            "night = thingd",
            "peach = cheapd",
            "players = 12345",
            "sadder = dreadds",
            "save = vasssssse",
            "state = tastetaste"},
            delimiterString = " = ")
    public void testCompareUnequal(String textL, String textR) {
        Assertions.assertFalse(Anagram.isAnagramOf(textL,textR), " The two text are anagram of each other: " + textL + "~=" + textR);
    }
}