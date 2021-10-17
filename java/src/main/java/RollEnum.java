public enum RollEnum {
    ONES(1),
    TWOES(2),
    THREES(3),
    FOURS(4),
    FIVES(5),
    SIXES(6);

    private int rollIndex;

    public int getRollIndex(){
        return rollIndex;
    }

    RollEnum(int rollIndex) {
        this.rollIndex = rollIndex;
    }
}
