import java.util.stream.IntStream;

public class Yatzy {

    public static IScore yatizService = new ScoreImpl();

    public static int chance(int... dice) {
        return IntStream.of(dice).sum();
    }

    public static int yatzy(int... dice)
    {
        return yatizService.yatzy(dice);
    }

    public static int ones(int... dice) {
        return Roll.rollDice(dice, RollEnum.ONES);
    }

    public static int twos(int... dice) {
        return Roll.rollDice(dice, RollEnum.TWOES);
    }

    public static int threes(int... dice) {
        return Roll.rollDice(dice, RollEnum.THREES);
    }

    public static int fours(int... dice) {
        return Roll.rollDice(dice, RollEnum.FOURS);
    }

    public static int fives(int... dice) {
        return Roll.rollDice(dice, RollEnum.FIVES);
    }

    public static int sixes(int... dice) {
        return Roll.rollDice(dice, RollEnum.SIXES);
    }

    public static int score_pair(int... dice) {
        return yatizService.score_pair(dice);
    }

    public static int two_pair(int... dice)
    {
        return yatizService.two_pair(dice);
    }

    public static int four_of_a_kind(int... dice)
    {
        return yatizService.four_of_a_kind(dice);
    }

    public static int three_of_a_kind(int... dice)
    {
        return yatizService.three_of_a_kind(dice);
    }

    public static int smallStraight(int... dice)
    {
        return yatizService.smallStraight(dice);
    }

    public static int largeStraight(int... dice) {
        return yatizService.largeStraight(dice);
    }

    public static int fullHouse(int... dice) {
        return yatizService.fullHouse(dice);
    }
}



