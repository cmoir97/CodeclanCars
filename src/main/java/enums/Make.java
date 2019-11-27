package enums;

public enum Make {
    FORD(5),
    HARLEYDAVIDSON(6),
    DUCATI(3),
    PORSCHE(7),
    KIA(0),
    FERRARI(9),
    AUSTIN(4),
    DACIA(2),
    VW(4);

private final int difficulty;

    Make(int difficulty) {
        this.difficulty = difficulty;
    }

    public int getDifficulty(){
        return this.difficulty;
    }
}
