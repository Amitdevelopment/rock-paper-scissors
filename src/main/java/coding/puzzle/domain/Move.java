package coding.puzzle.domain;

public enum Move {
    ROCK("Rock"), PAPER("Paper"), SCISSORS("Scissors");

    private String name;

    Move(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
