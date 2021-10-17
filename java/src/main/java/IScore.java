public interface IScore {
    public int score_pair(int[] dice);
    public int two_pair(int[] dice);
    public int four_of_a_kind(int[] dice);
    public int three_of_a_kind(int[] dice);
    public int smallStraight(int[] dice);
    public int largeStraight(int[] dice);
    public int fullHouse(int[] dice);
    public int yatzy(int[] dice);
}
