import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ScoreImpl implements IScore {

    @Override
    public int score_pair(int... dice) {
        return (Roll.checkOccurence(2, dice).findFirst().orElse(0)) * 2;
    }

    @Override
    public int two_pair(int... dice) {
        List<Integer> convertedList = Roll.checkOccurence(2, dice).map(Integer::valueOf)
            .collect(Collectors.toList());

        return (convertedList.get(0) + convertedList.get(1)) * 2;
    }

    @Override
    public int four_of_a_kind(int... dice) {
        return (Roll.checkOccurence(3, dice).findFirst().orElse(0)) * 4;
    }

    @Override
    public int three_of_a_kind(int... dice) {
        return (Roll.checkOccurence(3, dice).findFirst().orElse(0)) * 3;
    }

    @Override
    public int smallStraight(int... dice) {
        Set<Integer> setList = Arrays.stream(dice).boxed().collect(Collectors.toSet());
        Integer[] tempArraySorted = setList.toArray(new Integer[setList.size()]);
        Arrays.sort(tempArraySorted);
        int count = 0;
        for (int i = 1; i < tempArraySorted.length; i++) {
            if (tempArraySorted[i-1] + 1 == tempArraySorted[i]) {
                count ++;
            }
        }
        return count == 3 || count == 4 ? 15 : 0;
    }

    @Override
    public int largeStraight(int... dice) {
        Set<Integer> set = Arrays.stream(dice).boxed().collect(Collectors.toSet());
        return set.size() == 5 ? 20 : 0;
    }

    @Override
    public int fullHouse(int... dice) {
        Map<Integer, Long> occurrenceCollect = Arrays.stream(dice)
            .boxed()
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        if(occurrenceCollect.size() == 2) {
            Stream<Integer> maxOccurrence = occurrenceCollect.entrySet().stream()
                .filter(i -> i.getValue() >= 3).map(Map.Entry::getKey).sorted(Comparator.reverseOrder());

            List<Integer> ss = maxOccurrence.map(Integer::valueOf)
                .collect(Collectors.toList());

            Stream<Integer> maxOccurrence2 = occurrenceCollect.entrySet().stream()
                .filter(i -> i.getValue() == 2).map(Map.Entry::getKey).sorted(Comparator.reverseOrder());

            List<Integer> ss2 = maxOccurrence2.map(Integer::valueOf)
                .collect(Collectors.toList());

            return (ss.get(0) * 3) + (ss2.get(0) * 2);
        } else {
            return 0;
        }
    }

    @Override
    public int yatzy(int... dice) {
        Set<Integer> set = Arrays.stream(dice).boxed().collect(Collectors.toSet());
        return set.size() == 1 ? 50 : 0;
    }
}
