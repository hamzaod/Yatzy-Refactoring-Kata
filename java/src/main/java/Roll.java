import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Roll {
    public static int rollDice(int[] dice, RollEnum rollEnum) {
        IntStream stream = Arrays.stream(dice);
        return stream
            .filter(i -> i == rollEnum.getRollIndex())
            .sum();
    }

    public static Stream<Integer> checkOccurence(int val, int... dice) {
        Map<Integer, Long> occurrenceCollect = Arrays.stream(dice)
            .boxed()
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        Stream<Integer> maxOccurrence = occurrenceCollect.entrySet().stream()
            .filter(i -> i.getValue() >= val).map(Map.Entry::getKey).sorted(Comparator.reverseOrder());

        return maxOccurrence;
    }
}
