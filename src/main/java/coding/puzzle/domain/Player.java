package coding.puzzle.domain;

public enum Player {
    PLAYER1("Player 1"), PLAYER2("Player 2");

    String name;

    Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
